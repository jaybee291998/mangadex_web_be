package com.jaybee291998.mangadex.mangadex_web_be.bash;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class BashUtil {
    @Value("${com.jaybee291998.mangadex.bash.multi_script_path}")
    private String multiScriptPath;
    private static Process execBashScript(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(args);
        Process process = processBuilder.start();
        return process;
    }

    public String[] executeMultiDownload(String mangaId, String mangaName, String[] volumeNumbers) throws IOException {
        String cmdStr = "bash " + multiScriptPath + " -i " + mangaId + " -m " + mangaName + " ";
        cmdStr += String.join(" ", volumeNumbers);
        String[] cmdArr = cmdStr.split(" ");
        execBashScript(cmdArr);
        return cmdArr;
    }
}
