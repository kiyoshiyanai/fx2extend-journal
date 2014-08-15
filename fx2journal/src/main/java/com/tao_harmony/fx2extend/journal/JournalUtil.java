/*
 * Copyright (C) 2014 kyanai
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * aDouble with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tao_harmony.fx2extend.journal;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.orangesignal.csv.manager.CsvManager;
import com.orangesignal.csv.manager.CsvManagerFactory;

/**
 * @author kyanai
 *
 */
public class JournalUtil {

    /**
     * ͽ���ΰ�������������.����.
     */
    public static final short FX2_FILLER = 0;
    /**
     * �����ƥ��ʬ�ΰ�������������.999.
     */
    public static final short FX2_SYSTEM_CLASS = (short) 999;

    /**
     * ��������ȴ���ǻ����ե��������¸����.
     *
     * @param journals �����ꥹ��
     * @param fileName ��¸��
     * @throws NoListException �����ꥹ�Ȥ�Null���϶��ΤȤ�
     * @throws FileNameEmptyException �ե�����̾��Null���϶���ΤȤ�
     * @throws IOException �ե����륷���ƥ��ǥ��顼��ȯ�������Ȥ�
     */
    public static void saveJournals(List<Journal> journals, String fileName)
            throws NoListException, FileNameEmptyException, IOException {
        // Null�ʤ��㳰
        if (journals == null) {
            throw new NoListException();
        }
        // �ꥹ�Ȥ����Ǥ��㳰
        if (journals.isEmpty()) {
            throw new NoListException();
        }
        // �ե�����̾������ʤ��㳰
        if (StringUtils.isBlank(fileName)
                || StringUtils.isBlank(FilenameUtils.getName(fileName))) {
            throw new FileNameEmptyException();
        }
        // ��ĥ�Ҥ��.slp�פ��Ѵ�
        String name = FilenameUtils.getFullPath(fileName)
                + FilenameUtils.getBaseName(fileName) + ".slp";
        // ��¸
        CsvManager csvManager = CsvManagerFactory.newCsvManager();
        csvManager.save(journals, Journal.class).to(new File(name));
    }

    /**
     * �������٤�ޤ�ƻ����ե��������¸����. �������٤λ��ͤ�ʣ���Ǥ��뤿�ᡢ��侩���Υơ������ϤĤ��Ƥ��ʤ�����侩.
     *
     * @param journals �����ꥹ��
     * @param specifications �������٥ꥹ��
     * @param fileName ��¸��
     * @throws NoListException �����ꥹ�Ȥ�Null���϶��ΤȤ�
     * @throws IOException �ե����륷���ƥ��ǥ��顼��ȯ�������Ȥ�
     * @throws FileNameEmptyException �ե�����̾��Null���϶���ΤȤ�
     */
    public static void saveJournals(List<Journal> journals,
            List<DepartmentSpecification> specifications, String fileName)
            throws NoListException, IOException, FileNameEmptyException {
        // �����ե��������¸����ꤲ����
        saveJournals(journals, fileName);
	// ���������������٥ե��������¸
        // �ޤ���ĥ�Ҥ��.cls�פ��Ѵ�
        String name = FilenameUtils.getFullPath(fileName)
                + FilenameUtils.getBaseName(fileName) + ".cls";
        CsvManager csvManager = CsvManagerFactory.newCsvManager();
        csvManager.save(specifications, DepartmentSpecification.class).to(new File(name));
    }

}
