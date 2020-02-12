package dps.hivetools.service;

import dps.common.utils.NDateUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author pengshengpeng
 * @Date 2020/2/10 16:07
 **/
@Slf4j
public class ShellUtil {
    /**
     * 创建执行sql的shell文件
     *
     * @param path      生成shell文件的存放目录
     * @param tableName sql表名
     * @throws IOException 异常
     */
    public static void createExcuteHiveShell(String path, String tableName) throws IOException {
        String fileName = "exec_" + tableName + "_yyyymmdd.sh";
        File sh = new File(path, fileName);
        if (sh.exists()) {
            sh.delete();
        }
        sh.createNewFile();
        sh.setExecutable(true);
        try (
                FileWriter fw = new FileWriter(sh);
                BufferedWriter bf = new BufferedWriter(fw);
        ) {
            String[] hiveCommand = {"date=$1", "echo ${date}", "hive --hiveconf yyyymmdd='${date}' -f create_" + tableName + "_${date}.sql"};
            for (int i = 0; i < hiveCommand.length; i++) {
                bf.write(hiveCommand[i]);
                if (i < hiveCommand.length - 1) {
                    bf.newLine();
                }
            }
            bf.flush();
            bf.close();
        } catch (Exception e) {
            log.error("执行sql的shell文件生成失败", e.getMessage());
        }
    }

    /**
     * 创建导入数据的shell文件
     *
     * @param path      生成shell文件的存放目录
     * @param tableName sql表名
     * @throws Exception 异常
     */
    public static void createPutHiveShell(String path, String tableName) throws Exception {
        String fileName = "put_" + tableName + "_yyyymmdd.sh";
        File sh = new File(path, fileName);
        if (sh.exists()) {
            sh.delete();
        }
        sh.createNewFile();
        sh.setExecutable(true);
        try (
                FileWriter fw = new FileWriter(sh);
                BufferedWriter bf = new BufferedWriter(fw);
        ) {
            String[] hiveCommand = {"originPath=$1", "targetPath=$2", "echo ${originPath}", "echo ${targetPath}", "hdfs dfs -put ${originPath} ${targetPath}"};
            for (int i = 0; i < hiveCommand.length; i++) {
                bf.write(hiveCommand[i]);
                if (i < hiveCommand.length - 1) {
                    bf.newLine();
                }
            }
            bf.flush();
            bf.close();
        } catch (Exception e) {
            log.error("导入数据的shell文件生成失败", e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
        File file = new File(NDateUtil.getDays());
        ShellUtil.createExcuteHiveShell(file.getPath(), "O_LDM_DSR");
        ShellUtil.createPutHiveShell(file.getPath(), "O_LDM_DSR");
    }
}
