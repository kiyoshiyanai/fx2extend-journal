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
	 * 予備領域に挿入する定数.ゼロ.
	 */
	public static final short FX2_FILLER = 0;
	/**
	 * システム区分領域に挿入する定数.999.
	 */
	public static final short FX2_SYSTEM_CLASS = (short) 999;

	/**
	 * 部門明細抜きで仕訳ファイルを保存する.
	 *
	 * @param journals
	 *            仕訳リスト
	 * @param fileName
	 *            保存先
	 * @throws NoListException
	 *             仕訳リストがNull又は空のとき
	 * @throws FileNameEmptyException
	 *             ファイル名がNull又は空白のとき
	 * @throws IOException
	 *             ファイルシステム上でエラーが発生したとき
	 */
	public static void saveJournals(List<Journal> journals, String fileName)
			throws NoListException, FileNameEmptyException, IOException {
		// Nullなら例外
		if (journals == null) {
			throw new NoListException();
		}
		// リストが空でも例外
		if (journals.isEmpty()) {
			throw new NoListException();
		}
		// ファイル名が空白なら例外
		if (StringUtils.isBlank(fileName)
				|| StringUtils.isBlank(FilenameUtils.getName(fileName))) {
			throw new FileNameEmptyException();
		}
		// 拡張子を「.slp」に変換
		String name = FilenameUtils.getFullPath(fileName)
				+ FilenameUtils.getBaseName(fileName) + ".slp";
		// 保存
		CsvManager csvManager = CsvManagerFactory.newCsvManager();
		csvManager.save(journals, Journal.class).to(new File(name));
	}

	/**
	 * 部門明細を含めて仕訳ファイルを保存する. 部門明細の仕様が複雑であるため、非推奨アノテーションはつけていないが非推奨.
	 *
	 * @param journals
	 *            仕訳リスト
	 * @param specifications
	 *            部門明細リスト
	 * @param fileName
	 *            保存先
	 * @throws NoListException
	 *             仕訳リストがNull又は空のとき
	 * @throws IOException
	 *             ファイルシステム上でエラーが発生したとき
	 * @throws FileNameEmptyException
	 *             ファイル名がNull又は空白のとき
	 */
	public static void saveJournals(List<Journal> journals,
			List<DepartmentSpecification> specifications, String fileName)
			throws NoListException, IOException, FileNameEmptyException {
		// 仕訳ファイルの保存を丸投げする
		saveJournals(journals, fileName);
		// ここから部門明細ファイルを保存
		// まず拡張子を「.cls」に変換
		String name = FilenameUtils.getFullPath(fileName)
				+ FilenameUtils.getBaseName(fileName) + ".cls";
		CsvManager csvManager=CsvManagerFactory.newCsvManager();
		csvManager.save(specifications, DepartmentSpecification.class).to(new File(name));
	}

}
