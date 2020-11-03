package com.tooonly.bean;

public class ColumnInfo {

    private String tableCataLog;

    private String isNullable;

    private String tableName;

    private String tableSchema;

    private String extra;

    private String columnName;

    private String columnKey;

    private Integer numericPrecision;

    private String privileges;

    private String columnComment;

    private Integer numericScale;

    private String columnType;

    private Integer ordinalPosition;

    private String dataType;

    public String getTableCataLog() {
        return tableCataLog;
    }

    public void setTableCataLog(String tableCataLog) {
        this.tableCataLog = tableCataLog;
    }

    public String isNullable() {
        return isNullable;
    }

    public void setNullable(String nullable) {
        isNullable = nullable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public Integer getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Integer numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "tableCataLog='" + tableCataLog + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", extra='" + extra + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", numericPrecision=" + numericPrecision +
                ", privileges='" + privileges + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", numericScale=" + numericScale +
                ", columnType='" + columnType + '\'' +
                ", ordinalPosition=" + ordinalPosition +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
