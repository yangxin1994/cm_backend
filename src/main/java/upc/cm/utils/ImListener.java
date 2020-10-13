package upc.cm.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import upc.cm.model.IntegrationMeter;
import upc.cm.repository.IntegrationMeterRe;

import java.util.ArrayList;
import java.util.List;


public class ImListener extends AnalysisEventListener<IntegrationMeter> {
    private static final int BATCH_COUNT = 1;
    List<IntegrationMeter> list = new ArrayList<IntegrationMeter>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private IntegrationMeterRe uploadDAO;
    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param uploadDAO
     */
    public ImListener(IntegrationMeterRe uploadDAO) {
        this.uploadDAO = uploadDAO;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(IntegrationMeter data, AnalysisContext context) {
        uploadDAO.save(data);
//        list.add(data);
//    // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (list.size() >= BATCH_COUNT) {
//        saveData();
//        // 存储完成清理 list
//        list.clear();
//    }
}

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();

    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        if(list.isEmpty() != true)
            uploadDAO.save(list.get(0));

    }
}
