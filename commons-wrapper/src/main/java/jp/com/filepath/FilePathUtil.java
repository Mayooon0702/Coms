/**
 * 
 */
package jp.com.filepath;

/**
 * File Path関連ユーティリティ
 */
public class FilePathUtil {

    /**
     * パスからファイル名を取得
     *
     * @param strFilePath フルパスのファイル名
     * @return 取得したファイル名
     */
    public static String getFilePath2File(String strFilePath) {
        String returnStr = "";
        if (strFilePath == null || strFilePath.length() <= 0) {

        } else {
            String[] strParts = strFilePath.split("/");
            returnStr = strParts[strParts.length - 1];
        }
        return returnStr;
    }

    /**
     * 親ディレクトリのファイル名を取得
     * @param fullPathFilename フルパス名
     * @return 上位のディレクトリ名
     */
    public static String getParentDir(String fullPathFilename) {
        //文字列の最後がディレクトリの場合はカット
        if (fullPathFilename.charAt(fullPathFilename.length() - 1) == '/') {
            fullPathFilename = fullPathFilename.substring(0,fullPathFilename.length() - 2);
        }
        int index = fullPathFilename.lastIndexOf('/');
        if (index != -1) {
            return fullPathFilename.substring(0, index);
        }
        return "";
    }

    /**
     * ファイル名称から拡張子を外し返却
     *
     * @param fileName
     * @return
     */
    public static String getNameWithoutExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index != -1) {
            return fileName.substring(0, index);
        }
        return "";
    }

    /**
     * ファイル名称の拡張子を返却
     *
     * @param fileName ファイル名称
     * @return 拡張子
     */
    public static String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index != -1) {
            return fileName.substring(index + 1, fileName.length());
        }
        return fileName;
    }
    
}
