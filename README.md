# Rent Collection App

The Rent Collection App is a mobile application developed using Kotlin. It serves as a tool for managing rent payments and property-related tasks.

## Features

### MainActivity.kt

- Provides the main interface of the application.
- Allows users to register or login to access the app's features.
- Contains buttons to navigate to the registration and login screens.

### RegisterActivity.kt

- Enables users to create a new account by providing their email and password.
- Validates user inputs and displays appropriate error messages.
- Uses Firebase Authentication to handle user registration.

### LoginActivity.kt

- Allows registered users to log in to the app using their credentials.
- Authenticates user login using Firebase Authentication.
- Redirects authenticated users to the dashboard upon successful login.

### DashboardActivity.kt

- Displays a dashboard interface with various options for managing rent and property.
- Includes buttons to pay rent, view room details, and contact caretakers.
- Utilizes intents to navigate to different activities based on user actions.

### PayActivity.kt

- Facilitates rent payment by collecting user input for email, phone number, and payment amount.
- Passes user input to the Checkout activity for processing payment.
- Integrates with the Checkout activity to initiate the payment process.

### Checkout.kt

- Renders a web view for processing online payments using the iPay payment gateway.
- Retrieves user details (email, phone, amount) from the PayActivity and generates a payment URL.
- Loads the payment URL in the web view for users to complete the payment process.

## Usage

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Run the application on an Android emulator or physical device.
4. Register a new account or log in with existing credentials.
5. Use the dashboard to navigate through different features and functionalities.

## Technologies Used

- Kotlin
- Firebase Authentication
- Android WebView
- iPay Payment Gateway

## Contributing

Contributions to the Rent Collection App project are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes and ensure they follow the project's coding standards.
4. Test your changes thoroughly.
5. Submit a pull request with a clear description of the changes you've made and why they're beneficial.

## License

This project is licensed under the [MIT License](LICENSE).
