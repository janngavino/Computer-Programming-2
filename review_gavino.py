# Calculate the surface area of the torus using the formula
def calculate_surface_area(R, r):
    pi = 3.1416
    return (2 * pi * R) * (2 * pi * r)

# Calculate the volume of the torus using the formula
def calculate_volume(R, r):
    pi = 3.1416
    return (2 * pi * R) * (pi * r**2)

def get_radii():
# Loop to ensure valid radius inputs
    while True:
        try:
            # Input major and minor radius
            R = float(input("Enter the major radius (R): "))
            r = float(input("Enter the minor radius (r): "))

            # Check if both radii are greater than zero
            if R <= 0 or r <= 0:
                 # Restart the loop for valid input
                print("Both radii must be greater than zero. Please try again.")
                continue

            # Check if minor radius is not greater than major radius
            if r > R:
                # Restart the loop for valid input
                print("Minor radius (r) cannot be greater than major radius (R). Please try again.")
                continue

            # Return valid radii
            return R, r

        except ValueError:
            # Handle non-numeric input
            print("Invalid input. Please enter numeric values for the radii.")

def main():
    # Greeting message
    print("Welcome to the Torus Calculator!")
    # Loop to allow multiple calculations
    while True:
        print("\nTorus Calculator")
        print("1. Calculate Surface Area")
        print("2. Calculate Volume")

        # Prompt user to choose an option
        choice = input("Choose an option (1/2): ")

        if choice not in ['1', '2']:
            # Restart the loop for valid input
            print("Invalid choice. Please select 1 or 2.")
            continue

        # Get valid radii from the user
        R, r = get_radii()

        # Calculate and display the result based on user choice
        if choice == '1':
            surface_area = calculate_surface_area(R, r)
            print(f"Surface Area of the torus: {surface_area:.4f}")
        elif choice == '2':
            volume = calculate_volume(R, r)
            print(f"Volume of the torus: {volume:.4f}")

        # Ask if the user wants to compute another set of values
        another = input("Do you want to compute another set of values? (yes/no): ").strip().lower()
        if another != 'yes':
            # Farewell message
            # Exit the program if the user does not want to continue
            print("Thank you for using the Torus Calculator! Goodbye!")
            break

if __name__ == "__main__":
     # Start the program
    main()
