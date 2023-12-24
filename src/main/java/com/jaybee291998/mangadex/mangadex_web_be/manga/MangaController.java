package com.jaybee291998.mangadex.mangadex_web_be.manga;

import com.jaybee291998.mangadex.mangadex_web_be.bash.BashUtil;
import com.jaybee291998.mangadex.mangadex_web_be.manga.model.MangaDownloadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/manga")
public class MangaController {
    @Autowired
    private BashUtil bashUtil;
    @GetMapping("/{mangaId}")
    public ResponseEntity<?> downloadManga(@PathVariable String mangaId) throws IOException {
        String[] volumes = {"1", "2", "3"};
        return ResponseEntity.ok(String.join(" ", bashUtil.executeMultiDownload("1234", "naruto", volumes)));
    }

    @PostMapping("/")
    public ResponseEntity<?> downloadManga(@RequestBody MangaDownloadRequest mangaDownloadRequest) {
        try {
            bashUtil.executeMultiDownload(mangaDownloadRequest.getMangaId(), mangaDownloadRequest.getMangaName(), mangaDownloadRequest.getVolumes());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("failed to download ");
        }
        return ResponseEntity.ok(mangaDownloadRequest);
    }
}
