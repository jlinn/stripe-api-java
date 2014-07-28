# Changelog

### 2014-07-28
* Add [Refunds](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fapi%2FRefunds.java) api
* Add `failureMessage` and `failureCode` fields to [TransferResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Ftransfers%2FTransferResponse.java)
* Add `forgiven` property to [InvoiceResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Finvoices%2FInvoiceResponse.java)
* Add `receiptEmail` property to [ChargeResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Fcharges%2FChargeResponse.java)
* Refactor `charges.RefundResponse` to `charges.RefundsResponse`
* Remove `type` property from and add `brand` and `funding` properties to [CardResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Fcards%2FCardResponse.java)

### 2014-06-04
* Update setter methods in [CreatedRequest](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Frequest%2FCreatedRequest.java)
* Add statementDescription to [InvoiceResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Finvoices%2FInvoiceResponse.java)

### 2014-05-29
* Clean up [Client](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2FClient.java)
* Add card parameter to [TransferResponse](https://github.com/jlinn/stripe-api-java/blob/master/src%2Fmain%2Fjava%2Fnet%2Fjoelinn%2Fstripe%2Fresponse%2Ftransfers%2FTransferResponse.java)