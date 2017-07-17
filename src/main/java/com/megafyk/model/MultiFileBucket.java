package com.megafyk.model;

import com.google.common.collect.Lists;

import java.util.List;

public class MultiFileBucket {
    List<FileBucket> files = Lists.newArrayList();

    public MultiFileBucket() {
        files.add(new FileBucket());
        files.add(new FileBucket());
        files.add(new FileBucket());
    }

    public List<FileBucket> getFiles() {
        return files;
    }

    public void setFiles(List<FileBucket> files) {
        this.files = files;
    }
}
