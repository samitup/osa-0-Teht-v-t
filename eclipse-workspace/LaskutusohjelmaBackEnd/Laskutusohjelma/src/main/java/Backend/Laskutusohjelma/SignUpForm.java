package Backend.Laskutusohjelma;
import javax.persistence.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SignUpForm {

	@Entity
	@Table(name = "signup")
		@Column(name = "userName")
		private String userName;

		@Id
		@Column(name = "password")
		private String password;

		
		public SignUpForm(String userName,  String password) {
			this.userName = userName;
			this.password = password;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}

	}


