# INFO201 Milestone 2 - Requirements Specification
Liam Lennon-Flynn - 4239344

## Summary Report
This Requirements Specification is for the company HV Lo-Fi. They are a shop that sell a bunch of retro music products. Here are some diagrams to help understand how the system will work.

### Links to PlantUML Diagrams
- Browsing Use Case Diagram: https://isgb.otago.ac.nz/info201/lenli455/assignments/blob/master/milestone2/browse.puml.
- Sale Use Case Diagram: https://isgb.otago.ac.nz/info201/lenli455/assignments/blob/master/milestone2/sale.puml.
- ERD: https://isgb.otago.ac.nz/info201/lenli455/assignments/blob/master/milestone2/erd.puml.
- Registration Lo-Fi UI Mockup: https://isgb.otago.ac.nz/info201/lenli455/assignments/blob/master/milestone2/registration.puml.
- View Cart Lo-Fi UI Mockup: https://isgb.otago.ac.nz/info201/lenli455/assignments/blob/master/milestone2/viewCart.puml.

## List of Business Rules
- Customer must be signed up/signed in to make a purchase.
- Customer must be at least 18 years of age.
- 15% GST Must be applied to price before sale.
- Gift wrapping must be available for each individual item in sale.
- Staff members must update their weekly staff picks.
- NZ customers must be able to make purchases from the Australian website and vice versa.

## Transcript Key Points
1. Search by:
   1. Name of artist, name of recording (album, ep, or single)
   2. Compilation albums with multiple artists, so searching for individual tracks would be helpful there
   3. Soundtracks
   4. Genre/style of music
   5. Era or specific year
   6. Producer or mastering engineer
   7. New Releases
   8. Related music, not just limited to one genre/section of the store
2. Staff Picks
   1. Customers can browse them
   2. Customers can follow certain staff members if they like their taste
   3. (Maybe) Keep old picks in a vault for historical purposes or searching
3. Cart
   1. Should be able to add items, change quantities and remove items all before checkout
4. Checkout
   1. Shipping address
   2. Payment details
   3. Gift wrapped specified, yes or no (sent to different recipient) (THIS SHOULD BE AN OPTION FOR EACH ITEM e.g. EACH INDIVIDUAL ITEM CAN BE GIFT WRAPPED AND SENT TO DIFFERENT LOCATIONS, OR GROUPED WITH OTHER ITEMS)
   4. If NZ customer buys from AUS store, 15% NZ GST is applied at the time of sale (vice versa)
   5. Can use NZ account in AUS store and vice versa
   6. Customers **HAVE** to sign up before they complete their purchase (MUST BE AT LEAST 18 TO SIGN UP)
      1. Full name
      2. Phone number
      3. Email address
      4. Date of birth (optional, help find more relevant suggestions)
      5. Way of indicating they are at least 18 wihtout giving birth date
      6. Country of residence
      7. etc
      8. Optional:
         1. Music tastes, styles, eras, favourite artists
5. Inventory
   1. Each store has its own inventory
   2. Customers can search for items across stores (help them find those rare wares)
   3. No need for warehouses
   4. Good B2B connections with distributors of new content (Items go straight from distributors to customers, shop is middle man)
   5. Off-the-shelf logistics management package

## List of Functional Requirements
- Register customer.
- Search for music (by artist, title, genre, etc).
- Browse music (i.e. related items, especially by genre).
- Update weekly staff picks.
- Add item to cart.
- Update cart (including view cart, remove item, update quantity).
- Ship purchased item(s).
- Gift-wrap item(s) (optional; incurs an extra charge).
- Check out cart.

## List of Additional Functions to Exclude at This Stage
- Storage and searching of track information and other detailed metadata for recordings. These will be managed by a third-party service e.g. Spotify.
- Authentication via third-party single sign-on provider.
- Promotion via facebook.
- A means for customers to "like" a particular staff member's musical tastes.
- A facility for searchiing for music snippets of melody or lyrics.