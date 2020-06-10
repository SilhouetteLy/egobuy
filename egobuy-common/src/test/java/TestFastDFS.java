import com.silhouette.egobuy.utils.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:53
 * @description:
 */
public class TestFastDFS {

    @Test
    public void testUpload() throws IOException, MyException {
        //创建一个配置文件。文件名任意。内容就是 tracker 服务器的地址。
        //使用全局对象加载配置文件。
        ClientGlobal.init("/Users/silhouette/git_demo/egobuy/egobuy-common/src/test/resources/client.conf");
        //创建一个 TrackerClient 对象
        TrackerClient trackerClient = new TrackerClient();
        //通过 TrackClient 获得一个 TrackerServer 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建一个 StrorageServer 的引用，可以是 null
        StorageServer storageServer = null;
        //创建一个 StorageClient ，参数需要 TrackerServer 和 StrorageServer
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //使用 StorageClient 上传文件。
        String[] strings = storageClient.upload_file("/Users/silhouette/Pictures/pap.er/2018_10_11_11_06_IMG_4257.JPG", "jpg", null);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testUploadByClient() throws Exception{
        FastDFSClient client = new FastDFSClient( "/Users/silhouette/git_demo/egobuy/egobuy-common/src/test/resources/client.conf");

        String file = client .uploadFile( "/Users/silhouette/Pictures/pap.er/2019_06_16_18_36_IMG_4666.JPG");

        System. out .println( file);

    }
}
