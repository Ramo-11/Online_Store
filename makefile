all: Main.class PurchaseCartItemsFrame.class ViewShoppingCartFrame.class BrowseProductsFrame.class CustomerMainFrame.class CustomerSignupFrame.class CustomerLoginFrame.class RemoveCustomerAccountFrame.class CreateCustomerAccountFrame.class CreateAdminAccountFrame.class RemoveProductFrame.class UpdateProductFrame.class AddProductFrame.class ViewProductsFrame.class AdminMainFrame.class AdminLoginFrame.class MainFrame.class ProductButton.class CustomerSignupButton.class CustomerLoginButton.class AdminButton.class CustomerController.class AdminController.class AccountController.class Customer.class Admin.class Account.class DataController.class Inventory.class NotStringException.class Product.class ShoppingCart.class

Main.class:
	javac -g Main.java

PurchaseCartItemsFrame.class:
	javac -g GUI/Frames/CustomerFrames/PurchaseCartItemsFrame.java

ViewShoppingCartFrame.class:
	javac -g GUI/Frames/CustomerFrames/ViewShoppingCartFrame.java

BrowseProductsFrame.class:
	javac -g GUI/Frames/CustomerFrames/BrowseProductsFrame.java

CustomerMainFrame.class:
	javac -g GUI/Frames/CustomerFrames/CustomerMainFrame.java

CustomerSignupFrame.class:
	javac -g GUI/Frames/CustomerFrames/CustomerSignupFrame.java

CustomerLoginFrame.class:
	javac -g GUI/Frames/CustomerFrames/CustomerLoginFrame.java

RemoveCustomerAccountFrame.class:
	javac -g GUI/Frames/AdminFrames/RemoveCustomerAccountFrame.java

CreateCustomerAccountFrame.class:
	javac -g GUI/Frames/AdminFrames/CreateCustomerAccountFrame.java

CreateAdminAccountFrame.class:
	javac -g GUI/Frames/AdminFrames/CreateAdminAccountFrame.java

RemoveProductFrame.class:
	javac -g GUI/Frames/AdminFrames/RemoveProductFrame.java

UpdateProductFrame.class:
	javac -g GUI/Frames/AdminFrames/UpdateProductFrame.java

AddProductFrame.class:
	javac -g GUI/Frames/AdminFrames/AddProductFrame.java

ViewProductsFrame.class:
	javac -g GUI/Frames/AdminFrames/ViewProductsFrame.java

AdminMainFrame.class:
	javac -g GUI/Frames/AdminFrames/AdminMainFrame.java

AdminLoginFrame.class:
	javac -g GUI/Frames/AdminFrames/AdminLoginFrame.java

MainFrame.class:
	javac -g GUI/Frames/MainFrame.java

ProductButton.class:
	javac -g GUI/Buttons/ProductButton.java

CustomerSignupButton.class:
	javac -g GUI/Buttons/CustomerSignupButton.java

CustomerLoginButton.class:
	javac -g GUI/Buttons/CustomerLoginButton.java

AdminButton.class:
	javac -g GUI/Buttons/AdminButton.java

CustomerController.class:
	javac -g Program/CustomerController.java

AdminController.class:
	javac -g Program/AdminController.java

AccountController.class:
	javac -g Program/AccountController.java

Customer.class:
	javac -g Program/Customer.java

Admin.class:
	javac -g Program/Admin.java

Account.class:
	javac -g Program/Account.java

DataController.class:
	javac -g Program/DataController.java

Inventory.class:
	javac -g Program/Inventory.java

NotStringException.class:
	javac -g Program/NotStringException.java

Product.class:
	javac -g Program/Product.java

ShoppingCart.class:
	javac -g Program/ShoppingCart.java

clean:
	rm *.class
	rm GUI/Buttons/*.class
	rm GUI/Frames/AdminFrames/*.class
	rm GUI/Frames/CustomerFrames/*.class
	rm GUI/Frames/*.class
	rm Program/*.class