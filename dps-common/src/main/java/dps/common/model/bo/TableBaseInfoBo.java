package dps.common.model.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableBaseInfoBo implements Serializable {

    private static final long serialVersionUID = -1;

    private String srcDbType;

    private String tgtDbType;

    private String tableSpace;

    private String tableName;

    private String tableComment;

    private String fileFormat;

    private String fields;

    private String location;

    private String srcFileName;

    private String tgtLocation;

    private String zipFile;

    public void setSrcDbType(String srcDbType) {
        this.srcDbType = srcDbType.trim();
    }

    public void setTgtDbType(String tgtDbType) {
        this.tgtDbType = tgtDbType.trim();
    }

    public void setTableSpace(String tableSpace) {
        this.tableSpace = tableSpace.trim();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName.trim();
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment.trim();
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat.trim();
    }

    public void setFields(String fields) {
        this.fields = fields.trim();
    }

    public void setLocation(String location) {
        this.location = location.trim();
    }

    public void setTgtLocation(String tgtLocation) {
        this.tgtLocation = tgtLocation.trim();
    }

    public void setZipFile(String zipFile) {
        this.zipFile = zipFile.trim();
    }

    public void setSrcFileName(String srcFileName) {
        this.srcFileName = srcFileName.trim();
    }
}
