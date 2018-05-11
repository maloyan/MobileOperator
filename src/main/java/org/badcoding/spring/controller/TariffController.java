package org.badcoding.spring.controller;

import org.badcoding.dao.interfaces.CustomerDAO;
import org.badcoding.dao.interfaces.TariffDAO;
import org.badcoding.hibernate.stored.Customer;
import org.badcoding.hibernate.stored.Tariff;
import org.badcoding.spring.form.TariffForm;
import org.badcoding.spring.form.UsersForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class TariffController {

    @Autowired
	TariffDAO tariffDAO;

	private Boolean is_admin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (session.getAttribute("is_admin") != null);
	}

	@RequestMapping("/tariff")
	public String users(HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		model.put("tariffForm", new TariffForm());
		return "/admin/tariff";
	}

	@RequestMapping(value = "/tariff_search", method = RequestMethod.GET)
	public String users_search(@ModelAttribute TariffForm tariffForm, HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		List<Tariff> result = new ArrayList<Tariff>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		try {
			Integer tariffId = tariffForm.getTariffId();
			String name = tariffForm.getName();
			Integer intMb = tariffForm.getIntMb();
			Integer intDay;
			Integer callDayPerMinute;
			Integer callNightPerMinute;
			Integer callPerDay;
			Integer sms;

            if (tariffId == null)
                tariffId = -1;
            /*
			if (!id_s.equals("") && (!first_name.equals("") || !last_name.equals("") || !company_s.equals("") || !address.equals("") || !email.equals("") || !personal_or_comm.equals("") || !passport.equals(""))) {
				errors.add(46);
				throw new Exception();
			}


			if (flight_s == "")
				flight_s = "-1";
			if (company_s == "")
				company_s = "-1";
			if (paid_s == "")
				paid_s = "-1";
            */

			if (tariffId != -1) {
				Customer t = customerDAO.getCustomerById(id_s);
				if (t != null)
					result.add(t);
			} else {
				result = customerDAO.listCustomers();
			}
			if (result.size() == 0) {
				errors.add(48);
				model.put("info", errors);
			} else {
				model.put("results", result);
			}

		} catch (Exception e) {
			model.put("errors", errors);
		}
		model.put("usersForm", usersForm);
		return "/admin/users";
	}

	@RequestMapping(value="/add_user", method=RequestMethod.POST)
	public @ResponseBody List<Integer> add_user(HttpServletRequest request, UsersForm usersForm) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}

            Integer id_s = usersForm.getId();
            String first_name = usersForm.getFirst_name();
            String last_name = usersForm.getLast_name();
            String company_s = usersForm.getCompany();
            String address = usersForm.getAddress();
            String email = usersForm.getEmail();
            String personal_or_comm = usersForm.getPersonal_or_commercial();
            String passport = usersForm.getPassport();

            /*
			Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (!email_regex.matcher(email).matches())
                errors.add(24);

			if (password.length() < 8)
				errors.add(21);
			if (name.length() < 4)
				errors.add(22);
			if (last_name.length() < 4)
				errors.add(23);

			if (users.getByEmail(email).size() != 0)
				errors.add(25);
            */
            Customer customer = new Customer();
            customer.setCustomerId(id_s);
            customer.setFirstName(first_name);
            customer.setLastName(last_name);
            customer.setCompany(company_s);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setCommersialOrPersonal(personal_or_comm);
            customer.setPassport(passport);
            customerDAO.addCustomer(customer);


		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/get_user", method=RequestMethod.GET)
	public @ResponseBody List<List<String>> get_user(HttpServletRequest request, @RequestParam int user_id) {
		List<String> errors = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		try {
			if (!is_admin(request)) {
				errors.add("45");
				throw new Exception();
			}
			Customer customer = customerDAO.getCustomerById(user_id);
			if (customer == null) {
				errors.add("48");
				throw new Exception();
			}

			List<String> t = new ArrayList<String>();

			t.add(Integer.toString(customer.getCustomerId()));
			t.add(customer.getFirstName());
			t.add(customer.getLastName());
			t.add(customer.getCompany());
			t.add(customer.getEmail());
			t.add(customer.getAddress());
			t.add(customer.getCommersialOrPersonal());
			t.add(customer.getPassport());
			result.add(t);
			result.add(errors);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add("43");
			result.add(errors);
		}
		return result;
	}

	@RequestMapping(value="/remove_user", method=RequestMethod.POST)
	public @ResponseBody List<Integer> remove_user(HttpServletRequest request, Integer user_id) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}
			Customer c = customerDAO.getCustomerById(user_id);
			if (c == null) {
				errors.add(50);
				throw new Exception();
			}
			customerDAO.removeCustomer(c);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/edit_user", method=RequestMethod.POST)
	public @ResponseBody List<Integer> edit_user(HttpServletRequest request, UsersForm usersForm) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}

            if (!is_admin(request)) {
                errors.add(45);
                throw new Exception();
            }

            Integer id_s = usersForm.getId();
            String first_name = usersForm.getFirst_name();
            String last_name = usersForm.getLast_name();
            String company_s = usersForm.getCompany();
            String address = usersForm.getAddress();
            String email = usersForm.getEmail();
            String personal_or_comm = usersForm.getPersonal_or_commercial();
            String passport = usersForm.getPassport();

            /*
			Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (!email_regex.matcher(email).matches())
                errors.add(24);

			if (password.length() < 8)
				errors.add(21);
			if (name.length() < 4)
				errors.add(22);
			if (last_name.length() < 4)
				errors.add(23);

			if (users.getByEmail(email).size() != 0)
				errors.add(25);
            */
            Customer customer = new Customer();
            customer.setCustomerId(id_s);
            customer.setFirstName(first_name);
            customer.setLastName(last_name);
            customer.setCompany(company_s);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setCommersialOrPersonal(personal_or_comm);
            customer.setPassport(passport);

            customerDAO.updateCustomer(customer);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}
}

