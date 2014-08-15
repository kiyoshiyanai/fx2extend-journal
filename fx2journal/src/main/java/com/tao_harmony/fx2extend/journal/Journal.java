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
 * 
 * FX2�ѻ����ǡ���. �ե�����쥤�����Ȥξܺ٤�ProFIT�򻲾ȤΤ���.
 */
public class Journal {

    /**
     * ��Ϳ�襳����.
     */
    private Short clientCode;
    /**
     * �ǡ������������ƥ��ʬ.���󥹥ȥ饯���Ǹ����ͤ���������.
     */
    private final Short systemClass = JournalUtil.FX2_SYSTEM_CLASS;
    /**
     * �쥳�����ֹ�.
     */
    private Integer recordNumber;
    /**
     * ���ǯ����.����ǥ��åȤ���.
     */
    private Integer tradingDay;
    /**
     * ��ɼ�ֹ�.��ư���֤ΤȤ��ϡ���������Ƥ⥷���ƥब��������֤���Τǡ����������ʤ�.
     */
    private Integer slipNumber;
    /**
     * ������ֹ�.4ʸ������.
     */
    private String evidenceNumber;
    /**
     * ���Ƕ�ʬ.
     */
    private Byte taxClass;
    /**
     * ���ȶ�ʬ.
     */
    private Byte segmentCode;
    /**
     * ��������.
     */
    private Short debitCode;
    /**
     * �����������.
     */
    private String debitSubCode;
    /**
     * ��������.
     */
    private Short creditCode;
    /**
     * �����������.
     */
    private String creditSubCode;
    /**
     * ���ڼ��ֹ�.
     */
    private String checkNumber;
    /**
     * ͽ���ΰ�1.
     */
    private final Short filler1 = JournalUtil.FX2_FILLER;
    /**
     * ������.
     */
    private Double ammount;
    /**
     * �����ǳ�.�����Ǥ�ȯ�����ʤ�������ޤ����ǹ��߷����ξ��ϥ������.
     */
    private Double taxAmmount;
    /**
     * �ǳ����϶�ʬ.��ȴ���������ľ����Ǥ򥷥��ƥ�Ǽ�ư�׻����Ƥ�����Τ�1�򥻥å�.
     */
    private Byte taxInputClass;
    /**
     * ������Ψ.��Ψ��100�ܤ򥻥åȤ���.���������ǳ�����ξ���0�򥻥å�.
     */
    private Integer taxRate;
    /**
     * ����襳����.��Ͽ����Ƥ��ʤ������ξ��ϥ���򥻥å�.
     * ������������������Ƥ��ʤ����ǡ���Ͽ����Ƥ��ʤ�����襳���ɤ����åȤ��줿��硢���顼�ˤʤ�Τ����.
     */
    private Integer customerCode;
    /**
     * �����̾.����襳���ɤ����åȤ���Ƥ�����ǡ����Ĥ��줬����Ǥʤ���硢��Ͽ����Ƥ�������̾���֤���������.
     */
    private String customer;
    /**
     * �ºݤλ������ѥ�����.
     */
    private Byte purchasePattern;
    /**
     * �ºݤλ�������ǯ����.ǯ��ξ��ϲ�2��ˡ�00�פ򥻥å�.
     */
    private Integer purchaseDayBegins;
    /**
     * �ºݤλ�����λǯ����.
     */
    private Integer purchaseDayEnds;
    /**
     * Ŧ��.
     */
    private String summary;
    /**
     * ͽ���ΰ�2.
     */
    private final Short filler2 = JournalUtil.FX2_FILLER;
    /**
     * ��������.
     */
    private Byte fundBalanceMajor;
    /**
     * ��⾮����.
     */
    private Byte fundBalanceMinor;
    /**
     * ���祳����.
     */
    private Short departmentCode;
    /**
     * �����.»�׼���Ϥ����Ƥ�1������ʳ��ϥ���򥻥å�.
     */
    private Byte departmentCount;
    /**
     * ���������϶�ʬ.�������٤��ǹ��߶�ۤ�ͭ���ˤ��뤫�ݤ�.1��ͭ��. �������٥ե������Ȥ�ʤ��¤�̵��̣.
     */
    private Byte departmentAmmountClass;
    /**
     * ͽ���ΰ�3.
     */
    private final Short filler3 = JournalUtil.FX2_FILLER;
    /**
     * ��ư��ʬ�ֹ�.�б��դ����ܤξ��ϥ���򥻥å�.
     */
    private Integer ruleNumber;
    /**
     * ��ʧͽ����.��ʧ������Ԥ�ʤ����ˤ����Ѥ��ʤ����ϥ���򥻥å�.
     */
    private Integer paymentDay;
    /**
     * ���ͽ����.���������Ԥ�ʤ����ˤ����Ѥ��ʤ����ϥ���򥻥å�.
     */
    private Integer recoveryDay;

    /**
     * @return clientCode
     */
    public Short getClientCode() {
        return clientCode;
    }

    /**
     * @param clientCode clientCode�򥻥åȤ���
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
     * @param recordNumber recordNumber�򥻥åȤ���
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
     * @param tradingDay tradingDay�򥻥åȤ���
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
     * @param slipNumber slipNumber�򥻥åȤ���
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
     * @param evidenceNumber evidenceNumber�򥻥åȤ���
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
     * @param taxClass taxClass�򥻥åȤ���
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
     * @param segmentCode segmentCode�򥻥åȤ���
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
     * @param debitCode debitCode�򥻥åȤ���
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
     * @param debitSubCode debitSubCode�򥻥åȤ���
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
     * @param creditCode creditCode�򥻥åȤ���
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
     * @param creditSubCode creditSubCode�򥻥åȤ���
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
     * @param checkNumber checkNumber�򥻥åȤ���
     */
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * @return ammount
     */
    public Double getAmmount() {
        return ammount;
    }

    /**
     * @param ammount ammount�򥻥åȤ���
     */
    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    /**
     * @return taxAmmount
     */
    public Double getTaxAmmount() {
        return taxAmmount;
    }

    /**
     * @param taxAmmount taxAmmount�򥻥åȤ���
     */
    public void setTaxAmmount(Double taxAmmount) {
        this.taxAmmount = taxAmmount;
    }

    /**
     * @return taxInputClass
     */
    public Byte getTaxInputClass() {
        return taxInputClass;
    }

    /**
     * @param taxInputClass taxInputClass�򥻥åȤ���
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
     * @param taxRate taxRate�򥻥åȤ���
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
     * @param customerCode customerCode�򥻥åȤ���
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
     * @param customer customer�򥻥åȤ���
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
     * @param purchasePattern purchasePattern�򥻥åȤ���
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
     * @param purchaseDayBegins purchaseDayBegins�򥻥åȤ���
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
     * @param purchaseDayEnds purchaseDayEnds�򥻥åȤ���
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
     * @param summary summary�򥻥åȤ���
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
     * @param fundBalanceMajor fundBalanceMajor�򥻥åȤ���
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
     * @param fundBalanceMinor fundBalanceMinor�򥻥åȤ���
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
     * @param departmentCode departmentCode�򥻥åȤ���
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
     * @param departmentCount departmentCount�򥻥åȤ���
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
     * @param departmentAmmountClass departmentAmmountClass�򥻥åȤ���
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
     * @param ruleNumber ruleNumber�򥻥åȤ���
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
     * @param paymentDay paymentDay�򥻥åȤ���
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
     * @param recoveryDay recoveryDay�򥻥åȤ���
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
    public Short getFiller2() {
        return filler2;
    }

    /**
     * @return filler3
     */
    public Short getFiller3() {
        return filler3;
    }

}
