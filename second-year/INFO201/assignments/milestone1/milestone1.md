# INFO201 Milestone 1 - Requirements Elicitation
Liam Lennon-Flynn 4239344

## HV Lo-Fi Information System
HV Lo-Fi are an Australasian Retailer specialising in new and old vinyl record, compact cassette, record players, cassette players, headphones, and accessories such as cleaning kits and blank tapes.

HV Lo-Fi wishes to procure an information system that can support their online business operations for the next five to ten years.

## Stakeholders

### Internal

* Cashiers and other shop staff
* Stock Workers
* Management
* Current Customers
* Accountant
* Social Media Promoter

### External

* Stock Suppliers
* Shareholders
* Music Artists
* Record Labels
* Vinyl Record and Cassette Tape Factories
* Record Player and Cassette Player repair shops
* Potential Customers
* Vinyl/Cassette Collectors
* Government (GST)
* Delivery Companies
* HV Lo-Fi's Bank
* Building Companies
* Real Estate Companies

## Requirements

### Functional

Must Have:

* Online Shop - A website where customers can purchase items and have them delivered to them. 
  * Stakeholders - **customer**, **stock workers**, **stock suppliers**, **shareholders**, **music artists**, **record labels**, **vinyl record and cassette tape factories**, **record player and cassette player repair shops**, **potential customers**, **delivery companies**
* Menus - A way of navigating through the website "Shop", "Checkout", "My Account" etc. 
  * Stakeholders - **customer**
* Select Quantity of Item - The ability to select how many of a particular item you would like to add to cart.
  * Stakeholders - **customer**
* Add Item to Cart - The ability to add items to the cart so that they can be purchased.
  * Stakeholders - **customer**
* Remove Item from Cart - The ability to remove items you don't want from the cart.
  * Stakeholders - **customer**
* Checkout - A way to pay for your items and get them delivered to you. Must add your contact details and delivery address before you pay.
  * Stakeholders - **customer**
* Sale Invoice - A sale invoice including: Company details (name, address, phone number), customer details (name, address, phone number), date, invoice number, GST number, NZBN, description of each item (name, quantity, unit price, amount, subtotal, GST, amount due). Sent by email and attached to package.
  * Stakeholders - **customer**, **accountant**
* Pay by Credit Card - The ability to pay by credit card
  * Stakeholders - **customer**, **bank**
* Pay by PayPal - The abililty to pay by PayPal
  * Stakeholders - **customer**
* Can Shop Without Account - The ability to complete your online shopping and checkout without having to make an account.
  * Stakeholders - **customer**
* Custom Website for NZ - A custom website for NZ which has prices in NZD and is linked to the NZ stores/warehouses.
  * Stakeholders - **customer**, **government**
* Custom Website for Australia - A custom website for Australia which has prices in AUD and is linked to the Australia stores/warehouses.
  * Stakeholders - **customer**
* Run NZ and Australia Online Stores from the Same System - The ability to manage and control the NZ and Australia online stores from the same system.
  * Stakeholders - **customer**
* Contact Us - A section on the website with a way to contact the company.
  * Stakeholders - **customer**, **staff**, **management**
* Customer Support - Somewhere customers can get help with technical issues, complaints, sales.
  * Stakeholders - **customer**, **staff**
* Delivery - A delivery service to get the stock from the warehouses to the customers.
  * Stakeholders - **customer**, **delivery companies**
* Warehouse - A warehouse or warehouses to store the stock while it waits to be purchased.
  * Stakeholders - **customer**, **real estate companies**, **building companies**

Should Have:

* Have Full Selection - Have all items that are available in the physical stores on the online store.
  * Stakeholders - **customer** 
* Ship Rare Second Hand Items - Shipping second hand items of significant value to different stores or maybe even straight to customers for an added fee (depending on the rarity/value of the item).
  * Stakeholders - **customer**, **stock workers**, **delivery companies**
* Pay by Apple Pay/Google Pay - The ability to pay by Apple Pay or Google Pay.
  * Stakeholders - **customer**, **apple and google**
* Sign Up - The ability to sign up and create an account so you can see past orders, quickly checkout with saved details, and you get access to the loyalty scheme benefits. Need name, phone number, email address, postal address, password, music preferences (genres, years), favourite artists. Optionally D.O.B for birthday rewards.
  * Stakeholders - **customer**
* Guesses Which County Customer is Connecting From - Uses location services to find which country the customer is in and direct them to the appropriate website.
  * Stakeholders - **customer**
* Categories - Menus to find specific types of items, or genres of music.
  * Stakeholders - **customer**
* Search Bar - A search bar where you can type in keywords and find what you are looking for without navigating through the menus.
  * Stakeholders - **customer**
* Refine Search - A way to refine your search by cutting out items or genres of music you dont want.
  * Stakeholders - **customer**
* Sort By - A way to sort the listings on the page however you desire (alphabetically, by price etc)
  * Stakeholders - **customer**
* Nice Simple Design - A simple design which isn't distracting, makes it easier to use and navigate through the website.
  * Stakeholders - **customer**

Could Have:

* Pay by Direct Debit - The ability to pay by direct debit
  * Stakeholders - **customer**, **banks**
* Gift Wrapping - The option to get your package gift wrapped and sent to someone without the price being on the package. The buyer still gets their invoice though.
  * Stakeholders - **customer**, **staff**
* Sign In with Social Media Account - The ability to sign in quickly with a social media account e.g. Facebook.
  * Stakeholders - **customer**, **social media promoter**
* Virtual Album Cover Stack - A virtual album cover stack alphabetically ordered, which you can flip through.
  * Stakeholders - **customer**
* Weekly Staff Picks - A section on the website main page which has the staffs recommended picks.
  * Stakeholders - **customer**, **staff**, **music artists**
* Find Song by Typing Lyrics - The ability to find a song by typing in a snippet of lyrics.
  * Stakeholders - **customer**
* Ads - Could run ads on the side of the website, out of the way of everything, to get more money.
  * Stakeholders - **customer**, **shareholders**, **management**

Won't Have:

* Find Song by Humming - The ability to hum part of a song and the system find the song you were humming.
  * Stakeholders - **customer**
* Smartphone Apps - Apps for mobile devices with the store on them.
  * Stakeholders - **customer**, **shareholders**

### Non-Functional

* Usability
* Reliability
* Performance
* Security/Supportability
  * Local Privacy Law
* Reuse
* Economic Constraits and Tradeoffs
* Aesthetic Concerns
* Comprehensibility
* Technology Constraints and Tradeoffs

## Glossary

**Customer** (n.): A person who buys things from the store

**NZ** (n.): The country New Zealand

**GST** (n.): Goods and Services Tax

**Vinyl** (n.): A large record which plays music once on a record player

**Cassette** (n.): A small tape which plays music once in a tape player

**NZBN** (n.): New Zealand Business Number

**Stock** (n.): Items which the company has for sale

## Questions for Follow-Up

1. If we were to turn this store into an app how would you want it to differ from the website?
2. Would you consider the musicians and record labels that you purchase vinyls and records from stakeholders?
3. Do you want to remove the idea of using other social media accounts to sign in as it could potentially be unsafe for customers if the social media website is breaking privacy laws?
4. Instead of trying to implement humming a tune to find a song, would you consider licensing software which can detect songs by their waveforms just from playin them e.g. Shazam?