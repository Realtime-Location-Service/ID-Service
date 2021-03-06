# ID-Service

Manages authentication and authorization. For authentication this application uses a very
simple approach. So it is the users responsibility not to insert any invalid user in the
database.

## How it works

For a user get authenticated the system must know the user first. There are two types of
users: *admin* and regular *user*. An admin cannot be created by a user sign-up process.
Admin account is created on company sign-up process. There can be only one admin per company.

*Signing up a company is restricted to Realtime Location Service authority.*

During a company sign-up process an admin account is created with an AppKey to use with the
application for all kinds of interaction. For example signing up users and getting user
locations and metadata, etc.

## API endpoints

1. **POST** /api/v1/company/signup

   **Description:** Endpoint to register a company. This is a restricted endpoint. This will not be provided to any personnel
   outside of the Realtime Location Service. All request must have a secret header.

   **Payload**

        {
            "name": "example",
            "domain": "example.com"
        }

2. **POST** /api/v1/user/signup

   **Description:** Endpoint to register users for the companies.

   **Payload** AppKey is a secret which will be provided while registering the company.
   UserId is a unique id for the company to identify their users. Any sign-up request
   having the already existing userId against an AppKey will not create any new user.

        {
         "appKey": "9Of0u659BiyVAmJ/58yzrw==",
         "userId": "test2"
        }

3. **GET** /api/v1/user/resolve

   **Description:** Endpoint to retrieve all users for a company/AppKey.

   **QueryString:** `?appKey=9Of0u659BiyVAmJ%2F58yzrw%3D%3D`

   **ResponseBody:**

       {
           "userId": "893caacf-3592-4682-af91-de8639f9b681",
           "role": "admin",
           "appKey": "2o4oyirltg1pt1IrNnMhEQ==",
           "companyId": "0435693e-7d86-4539-bfe9-ef1b232ec7b3",
           "subordinates": [
               {
                   "userId": "test"
               }
           ]
       }

## Release Notes

### 1.1.0

1. Upgraded libraries and dependencies.
2. Improved error response

### 1.0.1

Improved error response

### 1.0.0

Released first production version
