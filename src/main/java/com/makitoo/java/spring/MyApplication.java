package com.makitoo.java.spring;

import com.makitoo.Makitoo;
import com.makitoo.Report;
import com.makitoo.ReportFilter;
import com.makitoo.ReportType;
import com.makitoo.internal.Config;
import com.makitoo.internal.probes.CollectingProbeAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mclement on 5/17/2016.
 */
@ComponentScan
@EnableAutoConfiguration
public class MyApplication {

    public static void main(String[] args) {
        Makitoo makitoo = com.makitoo.MakitooJava.init(
                "REPLACE",
                "REPLACE",   // Application ID
                "REPLACE",                     // Application token
                "REPLACE"                                           // Current version of your application
        );

        makitoo.getConfig().setProxy("foobar-proxy.com", 8080);
        makitoo.getConfig().setMaxReportPerSecond(20);
        makitoo.getConfig().setMaxPersistedExceptionReport(20);
        makitoo.getConfig().setHttpSocketTimeout(100);

        makitoo.addCollectingProbes(new CollectingProbeAdapter() {
            @Override
            public void contribute(Report report) {
                report.report("customer","nicolas");
            }
        });


        makitoo.addReportFilters(new ReportFilter() {
            @Override
            public boolean shouldBuild(Throwable throwable, String s, ReportType reportType) {
                return throwable instanceof CustomException;
            }

            @Override
            public boolean shouldSend(Report report) {
                return true;
            }
        });


        Config config = (Config) makitoo.getConfig();
        config.recursiveContextSize.set(3);

        SpringApplication.run(MyApplication.class);
    }

}
