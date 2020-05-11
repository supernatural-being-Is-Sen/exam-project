package com.coolyusen.util;

import com.coolyusen.file.FastDfsFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 吴雨森
 * @data 2020/1/20
 */
@Component
public class FastDfsUtil {

    /**
     * 加载Tracker连接信息
     */
    static {
        try {
            //文件路径
            String filePath = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取StorageClient信息
     * @return
     */
    private StorageClient getStorageClient(){
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer connection = null;
        try {
            connection = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        通过TrackerServer连接信息可以访问到Storage连接信息，
        可以创建StorageClient对象存储Storage存储信息
         */
        StorageClient storageClient = new StorageClient(connection, null);
        return storageClient;
    }

    /**
     * 文件上传
     * @param fastDfsFile
     */
    public String[] upload(FastDfsFile fastDfsFile) throws IOException, MyException {
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("author",fastDfsFile.getAuthor());
        //通过StorageClient访问Storage,实现文件上传后的存储信息
        StorageClient storageClient = this.getStorageClient();
        /**
         * uploads[0] 文件上传所存储的Storage 的组名字
         * uploads[1] 文件存储到Storage上的文件名字
         */
        String[] uploads = storageClient.upload_file(fastDfsFile.getContent(),
                fastDfsFile.getExt(), metaList);
        return uploads;
    }

    /**
     * 获取文件信息
     * @param groupName 组名
     * @param remoteFileName 文件的储存路径名字
     */
    public FileInfo getFileInfo(String groupName,
                                String remoteFileName) throws IOException, MyException {
        //获取Storage
        StorageClient storageClient = this.getStorageClient();
        //获取文件嘻嘻弄西
        return storageClient.get_file_info(groupName,remoteFileName);
    }

    /**
     * 文件下载
     * @param groupName
     * @param remoteFileName
     */
    public InputStream download(String groupName,
                                String remoteFileName) throws IOException, MyException {
        //获取StorageClient
        StorageClient storageClient = this.getStorageClient();
        byte[] buffer = storageClient.download_file(groupName,remoteFileName);
        return new ByteArrayInputStream(buffer);

    }

    /**
     * 删除图片
     * @param groupName
     * @param remoteFileName
     */
    public void delete(String groupName,
                       String remoteFileName) throws IOException, MyException {
        //获取StorageClient
        StorageClient storageClient = this.getStorageClient();
        storageClient.delete_file(groupName,remoteFileName);
    }
}
