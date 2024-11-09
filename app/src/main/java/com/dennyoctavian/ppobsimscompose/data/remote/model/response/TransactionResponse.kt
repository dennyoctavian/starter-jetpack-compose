package com.dennyoctavian.ppobsimscompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("invoice_number") val invoiceNumber: String,
    @SerializedName("service_code") val serviceCode: String,
    @SerializedName("service_name") val serviceName: String,
    @SerializedName("transaction_type") val transactionType: String,
    @SerializedName("total_amount") val totalAmount: Long,
    @SerializedName("created_on") val createdOn: String,
)
