package com.sahafbanking.main.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Username cannot be blank")
	@Size(max=30, message="Username must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String salutation;
	@NotBlank(message="First name cannot be blank")
	@Size(max=30, message="First name must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String firstname;
	@Size(max=30, message="Middle name must be less than or equal to 30 characters (A-Z, a-z format only)")
	private String middlename;
	@NotBlank(message="Last name cannot be blank")
	@Size(max=30, message="Last name must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String lastname;
	@NotBlank(message="Gender cannot be blank")
	private String gender;
	@NotBlank(message="Father's name cannot be blank")
	@Size(max=30, message="Father's name must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String fathername;
	@NotBlank(message="Mother's name cannot be blank")
	@Size(max=30, message="Mother's name must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String mothername;
	@Email(regexp = "[a-z0-9#$%&][a-z0-9#$%&'\\.\\-_]*@[^\\.\\s@][a-z0-9_\\.\\-_]*\\.[a-z]{2,4}"
			, message="Envalid email!!")
	private String email;
	@NotBlank(message="Mobile number cannot be empty")
	@Size(max=10, message="Mobile Number must be of 10 digits")
	@Pattern(regexp="^[7-9][0-9]{9}$", message="Must start with 7/8/9 and of 10 digits")
	private String mobile;
	@NotBlank(message="State cannot be blank")
	@Size(max=30, message="State must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String state;
	@NotBlank(message="District cannot be blank")
	@Size(max=30, message="District must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String district;
	@NotBlank(message="Branch cannot be blank")
	@Size(max=30, message="Branch must be less than or equal to 30 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String branch;
	@NotBlank(message="Country cannot be blank")
	@Size(max=50, message="Country must be less than or equal to 50 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String country;
	@NotBlank(message="Password cannot be empty")
	@Size(min=5 ,max=15, message="Password must be of 5-15 Charachters (A-Z, a-z format only)")
	@Pattern(regexp="^\\d*[a-zA-Z][a-zA-Z0-9]*$", message="Password Must be Alphabets and digits only!")
	private String password;
	@NotBlank(message="Account type cannot be blank")
	@Size(max=50, message="Account type must be less than or equal to 50 characters (A-Z, a-z format only)")
	@Pattern(regexp="^[a-zA-z ]+([a-zA-Z ]+)*$", message="Must be Alphabets Only")
	private String accounttype;
	@NotBlank(message="Address cannot be blank")
	@Size(max=500, message="Address must be less than or equal to 500 characters (A-Z, a-z format only)")
	private String address;
	final private String role = "consumer";
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(
			@NotBlank(message = "Username cannot be blank") @Size(max = 30, message = "Username must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String salutation,
			@NotBlank(message = "First name cannot be blank") @Size(max = 30, message = "First name must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String firstname,
			@Size(max = 30, message = "Middle name must be less than or equal to 30 characters (A-Z, a-z format only)") String middlename,
			@NotBlank(message = "Last name cannot be blank") @Size(max = 30, message = "Last name must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String lastname,
			@NotBlank(message = "Gender cannot be blank") String gender,
			@NotBlank(message = "Father's name cannot be blank") @Size(max = 30, message = "Father's name must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String fathername,
			@NotBlank(message = "Mother's name cannot be blank") @Size(max = 30, message = "Mother's name must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String mothername,
			@Email(regexp = "[a-z0-9#$%&][a-z0-9#$%&'\\.\\-_]*@[^\\.\\s@][a-z0-9_\\.\\-_]*\\.[a-z]{2,4}", message = "Envalid email!!") String email,
			@NotBlank(message = "Mobile number cannot be empty") @Size(max = 10, message = "Mobile Number must be of 10 digits") @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Must start with 7/8/9 and of 10 digits") String mobile,
			@NotBlank(message = "State cannot be blank") @Size(max = 30, message = "State must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String state,
			@NotBlank(message = "District cannot be blank") @Size(max = 30, message = "District must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String district,
			@NotBlank(message = "Branch cannot be blank") @Size(max = 30, message = "Branch must be less than or equal to 30 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String branch,
			@NotBlank(message = "Country cannot be blank") @Size(max = 50, message = "Country must be less than or equal to 50 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String country,
			@NotBlank(message = "Password cannot be empty") @Size(min = 5, max = 15, message = "Password must be of 5-15 Charachters (A-Z, a-z format only)") @Pattern(regexp = "^\\d*[a-zA-Z][a-zA-Z0-9]*$", message = "Password Must be Alphabets and digits only!") String password,
			@NotBlank(message = "Account type cannot be blank") @Size(max = 50, message = "Account type must be less than or equal to 50 characters (A-Z, a-z format only)") @Pattern(regexp = "^[a-zA-z ]+([a-zA-Z ]+)*$", message = "Must be Alphabets Only") String accounttype,
			@NotBlank(message = "Address cannot be blank") @Size(max = 500, message = "Address must be less than or equal to 500 characters (A-Z, a-z format only)") String address) {
		super();
		this.salutation = salutation;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.fathername = fathername;
		this.mothername = mothername;
		this.email = email;
		this.mobile = mobile;
		this.state = state;
		this.district = district;
		this.branch = branch;
		this.country = country;
		this.password = password;
		this.accounttype = accounttype;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [salutation=" + salutation + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", gender=" + gender + ", fathername=" + fathername + ", mothername="
				+ mothername + ", email=" + email + ", mobile=" + mobile + ", state=" + state + ", district=" + district
				+ ", branch=" + branch + ", country=" + country + ", password=" + password + ", accounttype="
				+ accounttype + ", address=" + address + "]";
	}
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BankAccountEntity> accounts;

}
