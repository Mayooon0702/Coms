/**
 * 
 */
package jp.com.filepath;

/**
 * File Path�֘A���[�e�B���e�B
 */
public class FilePathUtil {

    /**
     * �p�X����t�@�C�������擾
     *
     * @param strFilePath �t���p�X�̃t�@�C����
     * @return �擾�����t�@�C����
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
     * �e�f�B���N�g���̃t�@�C�������擾
     * @param fullPathFilename �t���p�X��
     * @return ��ʂ̃f�B���N�g����
     */
    public static String getParentDir(String fullPathFilename) {
        //������̍Ōオ�f�B���N�g���̏ꍇ�̓J�b�g
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
     * �t�@�C�����̂���g���q���O���ԋp
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
     * �t�@�C�����̂̊g���q��ԋp
     *
     * @param fileName �t�@�C������
     * @return �g���q
     */
    public static String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index != -1) {
            return fileName.substring(index + 1, fileName.length());
        }
        return fileName;
    }
    
}
