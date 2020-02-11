package dps.common.model.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableFieldInfoBo implements Serializable {

    private static final long serialVersionUID = -1;

    private String tableSpace;

    private String tableName;

    private String tableComment;

    private String fieldName;

    private String fieldComment;

    private String fieldType;

    public void setTableSpace(String tableSpace) {
        this.tableSpace = tableSpace.trim();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName.trim();
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment.trim();
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName.trim();
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment.trim();
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType.trim();
    }
}
