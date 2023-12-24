package com.jaybee291998.mangadex.mangadex_web_be.manga.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class MangaDownloadRequest {
    private String mangaId;
    private String mangaName;
    private String[] volumes;
}
