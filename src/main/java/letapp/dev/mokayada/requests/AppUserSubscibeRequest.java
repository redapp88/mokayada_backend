package letapp.dev.mokayada.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppUserSubscibeRequest {
private String firstName;
private String lastName;
private Date birthDate;
private String sex;
private String phone;
private String email;
private String username;
private String password;

}
