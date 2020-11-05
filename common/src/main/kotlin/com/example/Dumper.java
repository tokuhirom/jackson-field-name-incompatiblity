package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Dumper {
    public static void dumpAll() throws Exception {
        String version = com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION.toString();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("jackson-" + version + ".md"))) {
            dumpInfo(writer, version);
            dumpObject(writer, new FooKt(true));
            writer.write("\n\n");
        }
    }

    public static void dumpInfo(BufferedWriter writer, String version) throws IOException {
        writer.write("### Jackson version: " + version + "\n\n");
    }

    public static void dumpObject(BufferedWriter writer, Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new KotlinModule());
        writer.write("\t" + objectMapper.writeValueAsString(object) + "\n\n");
    }
}
