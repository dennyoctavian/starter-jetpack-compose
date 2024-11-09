package com.dennyoctavian.ppobsimscompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class TransactionHistoryResponse(
    @SerializedName("invoice_number") val invoiceNumber: String,
    @SerializedName("transaction_type") val transactionType: String,
    val description: String,
    @SerializedName("total_amount") val totalAmount: Long,
    @SerializedName("created_on") val createdOn: String,
)
