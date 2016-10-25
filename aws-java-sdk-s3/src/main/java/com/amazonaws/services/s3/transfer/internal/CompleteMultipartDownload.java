/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.transfer.Transfer;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Helper class to merge all the individual part files into a destinationFile.
 */
@SdkInternalApi
public class CompleteMultipartDownload implements Callable<File> {
    private final List<Future<File>> partFiles;
    private final File destinationFile;
    private final DownloadImpl download;
    private Integer currentPartNumber;

    public CompleteMultipartDownload(List<Future<File>> files, File destinationFile, DownloadImpl download, Integer currentPartNumber) {
        this.partFiles = files;
        this.destinationFile = destinationFile;
        this.download = download;
        this.currentPartNumber = currentPartNumber;
    }

    @Override
    public File call() throws Exception {
        for (Future<File> file : partFiles) {
            ServiceUtils.appendFile(file.get(), destinationFile);
            download.updatePersistableTransfer(currentPartNumber++);
        }

        download.setState(Transfer.TransferState.Completed);
        return destinationFile;
    }
}
