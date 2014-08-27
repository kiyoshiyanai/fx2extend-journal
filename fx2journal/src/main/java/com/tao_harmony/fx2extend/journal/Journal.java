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

import com.orangesignal.csv.annotation.CsvColumn;
import com.orangesignal.csv.annotation.CsvEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author kyanai e21まいスター、FX2用仕訳データ. ファイルレイアウトの詳細はProFITを参照のこと.
 */
@CsvEntity(header = false)
public class Journal {

    /**
     * 関与先コード.
     */
    @CsvColumn(position = 0)
    private Short clientCode;
    /**
     * データ作成システム区分.コンストラクタで固定値を代入する.
     */
    @CsvColumn(position = 1, defaultValue = "999")
    private final Short systemClass = JournalUtil.FX2_SYSTEM_CLASS;
    /**
     * レコード番号.
     */
    @CsvColumn(position = 2)
    private Integer recordNumber;
    /**
     * 取引年月日.西暦でセットする.
     */
    @CsvColumn(position = 3)
    private Integer tradingDay;
    /**
     * 伝票番号.自動付番のときは、何を入れてもシステムが勝手に付番するので、ゼロで問題なし.
     */
    @CsvColumn(position = 4)
    private Integer slipNumber;
    /**
     * 証憑書番号.4文字以内.
     */
    @CsvColumn(position = 5)
    private String evidenceNumber;
    /**
     * 課税区分.
     */
    @CsvColumn(position = 6)
    private Byte taxClass;
    /**
     * 事業区分.
     */
    @CsvColumn(position = 7, defaultValue = "0")
    private Byte segmentCode;
    /**
     * 借方科目.
     */
    @CsvColumn(position = 8)
    private Short debitCode;
    /**
     * 借方補助科目.
     */
    @CsvColumn(position = 9)
    private String debitSubCode;
    /**
     * 貸方科目.
     */
    @CsvColumn(position = 10)
    private Short creditCode;
    /**
     * 貸方補助科目.
     */
    @CsvColumn(position = 11)
    private String creditSubCode;
    /**
     * 小切手番号.
     */
    @CsvColumn(position = 12)
    private String checkNumber;
    /**
     * 予備領域1.
     */
    @CsvColumn(position = 13)
    private final Short filler1 = JournalUtil.FX2_FILLER;
    /**
     * 取引金額.
     */
    @CsvColumn(position = 14)
    private Long ammount;
    /**
     * 消費税額.消費税が発生しない取引、または税込み経理の場合はゼロ固定.
     */
    @CsvColumn(position = 15)
    private Long taxAmmount;
    /**
     * 税額入力区分.税抜き経理かつ消費税をシステムで自動計算している場合のみ1をセット.
     */
    @CsvColumn(position = 16)
    private Byte taxInputClass;
    /**
     * 消費税率.税率の100倍をセットする.ただし、税外取引の場合は0をセット.
     */
    @CsvColumn(position = 17)
    private Integer taxRate;
    /**
     * 取引先コード.登録されていない取引先の場合はゼロをセット.
     * 仕訳が取引先管理されていない場合で、登録されていない取引先コードがセットされた場合、エラーになるので注意.
     */
    @CsvColumn(position = 18)
    private Integer customerCode;
    /**
     * 取引先名.取引先コードがセットされている場合で、かつそれがゼロでない場合、登録されている取引先名に置き換えられる.
     */
    @CsvColumn(position = 19)
    private String customer;
    /**
     * 実際の仕入日パターン.
     */
    @CsvColumn(position = 20)
    private Byte purchasePattern;
    /**
     * 実際の仕入開始年月日.年月の場合は下2桁に「00」をセット.
     */
    @CsvColumn(position = 21)
    private Integer purchaseDayBegins;
    /**
     * 実際の仕入終了年月日.
     */
    @CsvColumn(position = 22)
    private Integer purchaseDayEnds;
    /**
     * 摘要.
     */
    @CsvColumn(position = 23)
    private String summary;
    /**
     * 予備領域2.
     */
    @CsvColumn(position = 24, defaultValue = "")
    private final String filler2 = JournalUtil.FX2_NULL;
    /**
     * 資金大項目.
     */
    @CsvColumn(position = 25)
    private Byte fundBalanceMajor;
    /**
     * 資金小項目.
     */
    @CsvColumn(position = 26)
    private Byte fundBalanceMinor;
    /**
     * 部門コード.
     */
    @CsvColumn(position = 27)
    private Short departmentCode;
    /**
     * 部門数.損益取引はたいてい1、それ以外はゼロをセット.
     */
    @CsvColumn(position = 28)
    private Byte departmentCount;
    /**
     * 部門金額入力区分.部門明細の税込み金額を有効にするか否か.1で有効. 部門明細ファイルを使わない限り無意味.
     */
    @CsvColumn(position = 29)
    private Byte departmentAmmountClass;
    /**
     * 予備領域3.
     */
    @CsvColumn(position = 30)
    private final Short filler3 = JournalUtil.FX2_FILLER;
    /**
     * 自動仕分番号.対応付け不要の場合はゼロをセット.
     */
    @CsvColumn(position = 31)
    private Integer ruleNumber;
    /**
     * 支払予定日.支払管理を行わない等により使用しない場合はゼロをセット.
     */
    @CsvColumn(position = 32)
    private Integer paymentDay;
    /**
     * 回収予定日.入金管理を行わない等により使用しない場合はゼロをセット.
     */
    @CsvColumn(position = 33)
    private Integer recoveryDay;

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
     * @return tradingDay
     */
    public Integer getTradingDay() {
        return tradingDay;
    }

    /**
     * @param tradingDay tradingDayをセットする
     */
    public void setTradingDay(Integer tradingDay) {
        this.tradingDay = tradingDay;
    }

    /**
     * @return slipNumber
     */
    public Integer getSlipNumber() {
        return slipNumber;
    }

    /**
     * @param slipNumber slipNumberをセットする
     */
    public void setSlipNumber(Integer slipNumber) {
        this.slipNumber = slipNumber;
    }

    /**
     * @return evidenceNumber
     */
    public String getEvidenceNumber() {
        return evidenceNumber;
    }

    /**
     * @param evidenceNumber evidenceNumberをセットする
     */
    public void setEvidenceNumber(String evidenceNumber) {
        this.evidenceNumber = evidenceNumber;
    }

    /**
     * @return taxClass
     */
    public Byte getTaxClass() {
        return taxClass;
    }

    /**
     * @param taxClass taxClassをセットする
     */
    public void setTaxClass(Byte taxClass) {
        this.taxClass = taxClass;
    }

    /**
     * @return segmentCode
     */
    public Byte getSegmentCode() {
        return segmentCode;
    }

    /**
     * @param segmentCode segmentCodeをセットする
     */
    public void setSegmentCode(Byte segmentCode) {
        this.segmentCode = segmentCode;
    }

    /**
     * @return debitCode
     */
    public Short getDebitCode() {
        return debitCode;
    }

    /**
     * @param debitCode debitCodeをセットする
     */
    public void setDebitCode(Short debitCode) {
        this.debitCode = debitCode;
    }

    /**
     * @return debitSubCode
     */
    public String getDebitSubCode() {
        return debitSubCode;
    }

    /**
     * @param debitSubCode debitSubCodeをセットする
     */
    public void setDebitSubCode(String debitSubCode) {
        this.debitSubCode = debitSubCode;
    }

    /**
     * @return creditCode
     */
    public Short getCreditCode() {
        return creditCode;
    }

    /**
     * @param creditCode creditCodeをセットする
     */
    public void setCreditCode(Short creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * @return creditSubCode
     */
    public String getCreditSubCode() {
        return creditSubCode;
    }

    /**
     * @param creditSubCode creditSubCodeをセットする
     */
    public void setCreditSubCode(String creditSubCode) {
        this.creditSubCode = creditSubCode;
    }

    /**
     * @return checkNumber
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * @param checkNumber checkNumberをセットする
     */
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * @return ammount
     */
    public Long getAmmount() {
        return ammount;
    }

    /**
     * @param ammount ammountをセットする
     */
    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    /**
     * @return taxAmmount
     */
    public Long getTaxAmmount() {
        return taxAmmount;
    }

    /**
     * @param taxAmmount taxAmmountをセットする
     */
    public void setTaxAmmount(Long taxAmmount) {
        this.taxAmmount = taxAmmount;
    }

    /**
     * @return taxInputClass
     */
    public Byte getTaxInputClass() {
        return taxInputClass;
    }

    /**
     * @param taxInputClass taxInputClassをセットする
     */
    public void setTaxInputClass(Byte taxInputClass) {
        this.taxInputClass = taxInputClass;
    }

    /**
     * @return taxRate
     */
    public Integer getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate taxRateをセットする
     */
    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return customerCode
     */
    public Integer getCustomerCode() {
        return customerCode;
    }

    /**
     * @param customerCode customerCodeをセットする
     */
    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * @return customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer customerをセットする
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return purchasePattern
     */
    public Byte getPurchasePattern() {
        return purchasePattern;
    }

    /**
     * @param purchasePattern purchasePatternをセットする
     */
    public void setPurchasePattern(Byte purchasePattern) {
        this.purchasePattern = purchasePattern;
    }

    /**
     * @return purchaseDayBegins
     */
    public Integer getPurchaseDayBegins() {
        return purchaseDayBegins;
    }

    /**
     * @param purchaseDayBegins purchaseDayBeginsをセットする
     */
    public void setPurchaseDayBegins(Integer purchaseDayBegins) {
        this.purchaseDayBegins = purchaseDayBegins;
    }

    /**
     * @return purchaseDayEnds
     */
    public Integer getPurchaseDayEnds() {
        return purchaseDayEnds;
    }

    /**
     * @param purchaseDayEnds purchaseDayEndsをセットする
     */
    public void setPurchaseDayEnds(Integer purchaseDayEnds) {
        this.purchaseDayEnds = purchaseDayEnds;
    }

    /**
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary summaryをセットする
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return fundBalanceMajor
     */
    public Byte getFundBalanceMajor() {
        return fundBalanceMajor;
    }

    /**
     * @param fundBalanceMajor fundBalanceMajorをセットする
     */
    public void setFundBalanceMajor(Byte fundBalanceMajor) {
        this.fundBalanceMajor = fundBalanceMajor;
    }

    /**
     * @return fundBalanceMinor
     */
    public Byte getFundBalanceMinor() {
        return fundBalanceMinor;
    }

    /**
     * @param fundBalanceMinor fundBalanceMinorをセットする
     */
    public void setFundBalanceMinor(Byte fundBalanceMinor) {
        this.fundBalanceMinor = fundBalanceMinor;
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
     * @return departmentCount
     */
    public Byte getDepartmentCount() {
        return departmentCount;
    }

    /**
     * @param departmentCount departmentCountをセットする
     */
    public void setDepartmentCount(Byte departmentCount) {
        this.departmentCount = departmentCount;
    }

    /**
     * @return departmentAmmountClass
     */
    public Byte getDepartmentAmmountClass() {
        return departmentAmmountClass;
    }

    /**
     * @param departmentAmmountClass departmentAmmountClassをセットする
     */
    public void setDepartmentAmmountClass(Byte departmentAmmountClass) {
        this.departmentAmmountClass = departmentAmmountClass;
    }

    /**
     * @return ruleNumber
     */
    public Integer getRuleNumber() {
        return ruleNumber;
    }

    /**
     * @param ruleNumber ruleNumberをセットする
     */
    public void setRuleNumber(Integer ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    /**
     * @return paymentDay
     */
    public Integer getPaymentDay() {
        return paymentDay;
    }

    /**
     * @param paymentDay paymentDayをセットする
     */
    public void setPaymentDay(Integer paymentDay) {
        this.paymentDay = paymentDay;
    }

    /**
     * @return recoveryDay
     */
    public Integer getRecoveryDay() {
        return recoveryDay;
    }

    /**
     * @param recoveryDay recoveryDayをセットする
     */
    public void setRecoveryDay(Integer recoveryDay) {
        this.recoveryDay = recoveryDay;
    }

    /**
     * @return systemClass
     */
    public Short getSystemClass() {
        return systemClass;
    }

    /**
     * @return filler1
     */
    public Short getFiller1() {
        return filler1;
    }

    /**
     * @return filler2
     */
    public String getFiller2() {
        return filler2;
    }

    /**
     * @return filler3
     */
    public Short getFiller3() {
        return filler3;
    }

    /**
     * 初期化する.ただし、以下の項目は初期化しない.
     * <ul>
     * <li>関与先コード</li>
     * <li>取引年月日</li>
     * <li>その他システム上固定値を要求される項目</li>
     * </ul>
     */
    public void reset() {
        this.ammount = NumberUtils.LONG_ZERO;
        this.checkNumber = StringUtils.EMPTY;
        this.creditCode = NumberUtils.SHORT_ZERO;
        this.creditSubCode = StringUtils.EMPTY;
        this.customer = StringUtils.EMPTY;
        this.customerCode = NumberUtils.INTEGER_ZERO;
        this.debitCode = NumberUtils.SHORT_ZERO;
        this.debitSubCode = StringUtils.EMPTY;
        this.departmentAmmountClass = NumberUtils.BYTE_ZERO;
        this.departmentCode = NumberUtils.SHORT_ZERO;
        this.departmentCount = NumberUtils.BYTE_ZERO;
        this.evidenceNumber = StringUtils.EMPTY;
        this.fundBalanceMajor = NumberUtils.BYTE_ZERO;
        this.fundBalanceMinor = NumberUtils.BYTE_ZERO;
        this.paymentDay = NumberUtils.INTEGER_ZERO;
        this.purchaseDayBegins = NumberUtils.INTEGER_ZERO;
        this.purchaseDayEnds = NumberUtils.INTEGER_ZERO;
        this.purchasePattern = NumberUtils.BYTE_ZERO;
        this.recordNumber = NumberUtils.INTEGER_ZERO;
        this.recoveryDay = NumberUtils.INTEGER_ZERO;
        this.ruleNumber = NumberUtils.INTEGER_ZERO;
        this.segmentCode = NumberUtils.BYTE_ZERO;
        this.slipNumber = NumberUtils.INTEGER_ZERO;
        this.summary = StringUtils.EMPTY;
        this.taxAmmount = NumberUtils.LONG_ZERO;
        this.taxClass = NumberUtils.BYTE_ZERO;
        this.taxInputClass = NumberUtils.BYTE_ZERO;
        this.taxRate = NumberUtils.INTEGER_ZERO;
    }

    /**
     * toString(). デバッグ用.
     *
     * @return
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
