package upc.cm.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import upc.cm.model.SystemUser;

public class SuListener extends AnalysisEventListener<SystemUser> {
    @Override
    public void invoke(SystemUser systemUser, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
