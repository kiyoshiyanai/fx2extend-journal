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

/**
 * @author kyanai
 * 部門明細ファイルの明細データ.
 */
public class DepartmentSpecification {

	/**
	 * 関与先コード.
	 */
	private Short clientCode;
	/**
	 * データ作成システム区分.コンストラクタで固定値を代入する.
	 */
	private final Short systemClass = JournalUtil.FX2_SYSTEM_CLASS;
	/**
	 * レコード番号.
	 */
	private Integer recordNumber;
	/**
	 * 部門明細部レコード番号.仕訳ごとの通し番号.
	 */
	private Integer departmentRecordNumber;
	/**
	 * 部門コード.
	 */
	private Short departmentCode;
	/**
	 * 部門税込み金額.部門金額入力区分が1の場合のみ、この金額を税込み金額として処理する.
	 */
	private Double taxifiedAmount;
	/**
	 * 内訳金額.消費税が発生する取引の場合は税抜き金額を入れること.
	 */
	private Double amount;
	/**
	 * @return clientCode
	 */
	public Short getClientCode() {
		return clientCode;
	}
	/**
	 * @param clientCode clientCodeをセットする
	 */
	public void setClientCode(Short clientCode) {
		this.clientCode = clientCode;
	}
	/**
	 * @return recordNumber
	 */
	public Integer getRecordNumber() {
		return recordNumber;
	}
	/**
	 * @param recordNumber recordNumberをセットする
	 */
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}
	/**
	 * @return departmentRecordNumber
	 */
	public Integer getDepartmentRecordNumber() {
		return departmentRecordNumber;
	}
	/**
	 * @param departmentRecordNumber departmentRecordNumberをセットする
	 */
	public void setDepartmentRecordNumber(Integer departmentRecordNumber) {
		this.departmentRecordNumber = departmentRecordNumber;
	}
	/**
	 * @return departmentCode
	 */
	public Short getDepartmentCode() {
		return departmentCode;
	}
	/**
	 * @param departmentCode departmentCodeをセットする
	 */
	public void setDepartmentCode(Short departmentCode) {
		this.departmentCode = departmentCode;
	}
	/**
	 * @return taxifiedAmount
	 */
	public Double getTaxifiedAmount() {
		return taxifiedAmount;
	}
	/**
	 * @param taxifiedAmount taxifiedAmountをセットする
	 */
	public void setTaxifiedAmount(Double taxifiedAmount) {
		this.taxifiedAmount = taxifiedAmount;
	}
	/**
	 * @return amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount amountをセットする
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return systemClass
	 */
	public Short getSystemClass() {
		return systemClass;
	}

}
