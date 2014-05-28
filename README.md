stripe-api-java
===============

[![Build Status](https://secure.travis-ci.org/jlinn/stripe-api-java.png?branch=master)](http://travis-ci.org/jlinn/stripe-api-java)

A Java client library for [Stripe](https://stripe.com/docs/api)'s API.

## Usage

### Making API Calls
#### Initialize the client object
```java
Stripe stripe = new Stripe("your_api_key");
```

#### Customers calls
```java
// create a customer
CreateCustomerRequest customerRequest = new CreateCustomerRequest()
    .setEMail("foo@bar.com")
    .setDescription("A customer!")
    .setCard(new CreateCardRequest("4242424242424242", 1, 2020));
CustomerResponse customer = stripe.customers().createCustomer(customerRequest);

// retrieve the customer
CustomerResponse retrievedCustomer = stripe.customers().getCustomer(customer.getId());
```

#### Charges calls
```java
// create a charge
CreateChargeRequest chargeRequest = new CreateChargeRequest(350, "usd")
    .setCustomer(customer.getId());
ChargeResponse charge = stripe.charges().createCharge(chargeRequest);
```