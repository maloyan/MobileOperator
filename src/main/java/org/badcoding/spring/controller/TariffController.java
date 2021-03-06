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
import java.util.regex.Pattern;

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
	public String tariff(HttpServletRequest request, Map<String, Object> model) {
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
	public String tariff_search(@ModelAttribute TariffForm tariffForm, HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		List<Tariff> result = new ArrayList<Tariff>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		try {
			String id_s = tariffForm.getId();
			String name = tariffForm.getName();
            Integer id;
			if (!id_s.isEmpty()) {
                Pattern id_regex = Pattern.compile("[0-9]+");
                if (!id_regex.matcher(id_s).matches()) {
                    errors.add(15);
                    throw new Exception();
                }
                id = Integer.parseInt(id_s);
            } else {
			    id = null;
            }

            if (id == null && name.isEmpty()) {
                result = tariffDAO.listTariffs();
            } else if (id != null) {
                Tariff t = tariffDAO.getTariffById(id);
                if (t != null)
                    result.add(t);
            } else {
                result = tariffDAO.listTariffsByName(name);
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
		model.put("tariffForm", tariffForm);
		return "/admin/tariff";
	}

	@RequestMapping(value="/add_tariff", method=RequestMethod.POST)
	public @ResponseBody List<Integer> add_tariff(HttpServletRequest request, TariffForm tariffForm) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}

            Integer id = Integer.parseInt(tariffForm.getId());
            String name = tariffForm.getName();
            Integer intMb = tariffForm.getIntMb();
            Integer intDay = tariffForm.getIntDay();
            Integer callDayPerMinute = tariffForm.getCallDayPerMinute();
            Integer callNightPerMinute = tariffForm.getCallNightPerMinute();
            Integer callPerDay = tariffForm.getCallPerDay();
            Integer sms = tariffForm.getSms();

            if (id == null || name.isEmpty() || intMb == null || intDay == null || callDayPerMinute == null || callNightPerMinute == null
                    || callPerDay == null || sms == null) {
                errors.add(13);
                throw new Exception();
            }

            Tariff tariff = new Tariff();
            tariff.setTariffId(id);
            tariff.setName(name);
            tariff.setIntMb(intMb);
            tariff.setIntDay(intDay);
            tariff.setCallDayPerMinute(callDayPerMinute);
            tariff.setCallNightPerMinute(callNightPerMinute);
            tariff.setCallPerDay(callPerDay);
            tariff.setSms(sms);
            tariffDAO.addTariff(tariff);

		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/get_tariff", method=RequestMethod.GET)
	public @ResponseBody List<List<String>> get_tariff(HttpServletRequest request, @RequestParam int tariff_id) {
		List<String> errors = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		try {
			if (!is_admin(request)) {
				errors.add("45");
				throw new Exception();
			}
			Tariff tariff = tariffDAO.getTariffById(tariff_id);
			if (tariff == null) {
				errors.add("48");
				throw new Exception();
			}

			List<String> t = new ArrayList<String>();

			t.add(Integer.toString(tariff.getTariffId()));
			t.add(tariff.getName());
			t.add(Integer.toString(tariff.getIntMb()));
			t.add(Integer.toString(tariff.getIntDay()));
			t.add(Integer.toString(tariff.getCallDayPerMinute()));
			t.add(Integer.toString(tariff.getCallNightPerMinute()));
			t.add(Integer.toString(tariff.getCallPerDay()));
			t.add(Integer.toString(tariff.getSms()));
			result.add(t);
			result.add(errors);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add("43");
			result.add(errors);
		}
		return result;
	}

	@RequestMapping(value="/remove_tariff", method=RequestMethod.POST)
	public @ResponseBody List<Integer> remove_tariff(HttpServletRequest request, Integer tariff_id) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}
			Tariff tariff = tariffDAO.getTariffById(tariff_id);
			if (tariff == null) {
				errors.add(50);
				throw new Exception();
			}
			tariffDAO.removeTariff(tariff);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/edit_tariff", method=RequestMethod.POST)
	public @ResponseBody List<Integer> edit_tariff(HttpServletRequest request, TariffForm tariffForm) {
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

            Integer id = Integer.parseInt(tariffForm.getId());
            String name = tariffForm.getName();
            Integer intMb = tariffForm.getIntMb();
            Integer intDay = tariffForm.getIntDay();
            Integer callDayPerMinute = tariffForm.getCallDayPerMinute();
            Integer callNightPerMinute = tariffForm.getCallNightPerMinute();
            Integer callPerDay = tariffForm.getCallPerDay();
            Integer sms = tariffForm.getSms();

            Tariff tariff = new Tariff();

            tariff.setTariffId(id);
            tariff.setName(name);
            tariff.setIntMb(intMb);
            tariff.setIntDay(intDay);
            tariff.setCallDayPerMinute(callDayPerMinute);
            tariff.setCallNightPerMinute(callNightPerMinute);
            tariff.setCallPerDay(callPerDay);
            tariff.setSms(sms);

            tariffDAO.updateTariff(tariff);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}
}

