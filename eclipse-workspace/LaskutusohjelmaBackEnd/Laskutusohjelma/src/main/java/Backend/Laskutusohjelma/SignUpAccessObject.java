package Backend.Laskutusohjelma;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SignUpAccessObject {


		SessionFactory sessionfactor = null;
		Session sessio;
		org.hibernate.Transaction transaktio = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		public SignUpAccessObject() {

			try {
				sessionfactor = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			} catch (Exception e) {
				System.out.println("Oh no");
				StandardServiceRegistryBuilder.destroy(registry);
				e.printStackTrace();
			}
		}

		@Override
		public void finalize() {
			// destructor
			try {
				sessionfactor.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public boolean createUser(SignUpForm user) {
			boolean value = true;
			String userName = user.getUserName();
			String password = user.getPassword();

			sessio = sessionfactor.openSession();
			transaktio = null;

			try {
				transaktio = sessio.beginTransaction();
				SignUpForm f = new SignUpForm(userName, password);
				sessio.saveOrUpdate(f);

				transaktio.commit();
			} catch (Exception e) {
				if (transaktio != null)
					transaktio.rollback();
			} finally {
				sessio.close();
			}
			return value;
		}

	}


	

