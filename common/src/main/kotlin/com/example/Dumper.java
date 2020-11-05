package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Dumper {
    public static void dumpAll(String fileName) throws Exception {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            dumpInfo(writer);
            writer.write("### Java\n\n");
            dumpObject(writer, new FooJava(true));
            writer.write("### Kotlin\n\n");
            dumpObject(writer, new FooKt(true));
            writer.write("\n\n");
        }
    }

    public static void dumpInfo(BufferedWriter writer) throws IOException {
        String version = com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION.toString();
        writer.write("## Jackson version: " + version + "\n");
    }

    public static void dumpObject(BufferedWriter writer, Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new KotlinModule());
        writer.write(objectMapper.writeValueAsString(object) + "\n\n");
    }
}
