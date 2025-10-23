package com.memmcol.accountcreation.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"CustomerNew\"", schema = "dbo") // respects case-sensitive SQL table name
public class CustomerNew {
    @Id
    @Column(name = "AccountNo", nullable = false, length = 20)
    private String accountNo;

    @Column(name = "booknumber", nullable = false, length = 10)
    private String bookNumber;

    @Column(name = "oldaccountnumber", length = 20)
    private String oldAccountNumber;

    @Column(name = "MeterNo", length = 20)
    private String meterNo;

    @Column(name = "Surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "FirstName", length = 25)
    private String firstName;

    @Column(name = "OtherNames", length = 50)
    private String otherNames;

    @Column(name = "Address1", length = 200)
    private String address1;

    @Column(name = "Address2", length = 200)
    private String address2;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "State", length = 50)
    private String state;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "ServiceAddress1", length = 200)
    private String serviceAddress1;

    @Column(name = "ServiceAddress2", length = 200)
    private String serviceAddress2;

    @Column(name = "ServiceAddressCity", length = 50)
    private String serviceAddressCity;

    @Column(name = "ServiceAddressState", length = 50)
    private String serviceAddressState;

    @Column(name = "TariffID", nullable = false)
    private Integer tariffId;

    @Column(name = "ArrearsBalance", precision = 18, scale = 2)
    private BigDecimal arrearsBalance = BigDecimal.ZERO;

    @Column(name = "Mobile", length = 20)
    private String mobile;

    @Column(name = "MethodOfIdentification", length = 10)
    private String methodOfIdentification;

    @Column(name = "AcctTypeDesc", length = 50)
    private String acctTypeDesc;

    @Column(name = "ScheduleBillNO")
    private Integer scheduleBillNo;

    @Column(name = "Vat")
    private Boolean vat = Boolean.TRUE;

    @Column(name = "ApplicationDate")
    private LocalDateTime applicationDate;

    @Column(name = "PlaceOfWork", length = 50)
    private String placeOfWork;

    @Column(name = "AddressOfOrganisation", length = 40)
    private String addressOfOrganisation;

    @Column(name = "GIScoordinate", length = 20)
    private String gisCoordinate;

    @Column(name = "GuarantorName", length = 50)
    private String guarantorName;

    @Column(name = "GuarantorAddress", length = 50)
    private String guarantorAddress;

    @Column(name = "OrganisationCode", length = 10)
    private String organisationCode;

    @Column(name = "institutionCode", length = 10)
    private String institutionCode;

    @Column(name = "SetUpDate")
    private LocalDateTime setUpDate;

    @Column(name = "ConnectDate")
    private LocalDateTime connectDate;

    @Column(name = "DistributionStation", length = 50)
    private String distributionStation;

    @Column(name = "InjectionStation", length = 10)
    private String injectionStation;

    @Column(name = "UpriserNo")
    private Integer upriserNo;

    @Column(name = "UTID", nullable = false, length = 10)
    private String utid;

    @Column(name = "BUID", nullable = false, length = 5)
    private String buid;

    @Column(name = "TransID", length = 10)
    private String transId;

    @Column(name = "OperatorName", length = 20)
    private String operatorName;

    @Column(name = "Password", length = 40)
    private String password;

    @Column(name = "StatusCode", nullable = false, length = 10)
    private String statusCode;

    @Column(name = "ADC")
    private Integer adc;

    @Column(name = "StoredAverage", precision = 10, scale = 2)
    private BigDecimal storedAverage;

    @Column(name = "UseADC")
    private Boolean useAdc;

    @Column(name = "IsBulk")
    private Boolean isBulk;

    @Column(name = "DistributionID", length = 50)
    private String distributionId;

    @Column(name = "NewsetupDate")
    private LocalDateTime newSetupDate;

    @Column(name = "IsCAPMI")
    private Boolean isCapmi;

    @Column(name = "operatorEdits", length = 20)
    private String operatorEdits;

    @Column(name = "operatorEdit", length = 20)
    private String operatorEdit;

    @Column(name = "CAT", length = 5, columnDefinition = "char(5)")
    private String cat;

    @Column(name = "IsConfirmed")
    private Boolean isConfirmed;

    @Column(name = "ConfirmBy", length = 30)
    private String confirmBy;

    @Column(name = "DateConfirm")
    private LocalDateTime dateConfirm;

    @Column(name = "NAC", length = 30)
    private String nac;

    @Column(name = "BackBalance", precision = 18, scale = 2)
    private BigDecimal backBalance;

    @Column(name = "GIS", length = 30)
    private String gis;

    @Column(name = "CustomerID")
    private UUID customerId;

    @Column(name = "AceCustomerID", length = 50)
    private String aceCustomerId;

    @Column(name = "CenterID", length = 50)
    private String centerId;

    @Column(name = "AssetID", length = 50)
    private String assetId;

    @Column(name = "UpriserID", length = 50)
    private String upriserId;

    @Column(name = "HasTenant")
    private Boolean hasTenant;

    @Column(name = "LandLordName", length = 20)
    private String landLordName;

    @Column(name = "LandLordMobileNo", length = 20)
    private String landLordMobileNo;

    @Column(name = "CIN", length = 20)
    private String cin;

    @Column(name = "IsPrepaid")
    private Boolean isPrepaid;

    @Column(name = "MeterOEM", length = 20)
    private String meterOem;

    @Column(name = "LTPoleID", length = 30)
    private String ltPoleId;

    @Column(name = "Gender", length = 10)
    private String gender;

    @Column(name = "MaritalStatus", length = 10)
    private String maritalStatus;

    @Column(name = "BusinessType", length = 20)
    private String businessType;

    @Column(name = "rowguid", nullable = false)
    private UUID rowGuid;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CustomerNew that = (CustomerNew) o;
        return getAccountNo() != null && Objects.equals(getAccountNo(), that.getAccountNo());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
