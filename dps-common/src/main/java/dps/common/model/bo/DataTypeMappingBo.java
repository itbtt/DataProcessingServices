package dps.common.model.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataTypeMappingBo implements Serializable {

    private static final long serialVersionUID = -1;

    private String srcDbType;

    private String srcTypeCd;

    private String tgtDbType;

    private String tgtTypeCd;

    public void setSrcDbType(String srcDbType) {
        this.srcDbType = srcDbType.trim();
    }

    public void setSrcTypeCd(String srcTypeCd) {
        this.srcTypeCd = srcTypeCd.trim();
    }

    public void setTgtDbType(String tgtDbType) {
        this.tgtDbType = tgtDbType.trim();
    }

    public void setTgtTypeCd(String tgtTypeCd) {
        this.tgtTypeCd = tgtTypeCd.trim();
    }
}
