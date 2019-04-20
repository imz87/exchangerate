package ir.izo.exchangerate.controller;

import ir.izo.exchangerate.R;
import ir.izo.exchangerate.config.ApplicationConfig;
import ir.izo.exchangerate.enums.ConfigEnum;
import ir.izo.exchangerate.enums.FragmentEnum;
import ir.izo.exchangerate.model.InitializerModel;
import ir.izo.exchangerate.util.Logger;
import ir.izo.exchangerate.view.InitializerFragmentView;

import static ir.izo.exchangerate.util.AndroidUtil.goToFragment;
import static ir.izo.exchangerate.util.Validator.requireNonEmpty;

/**
 * This class manages the home view.
 */
public class InitializerController {
	private final static String TAG = InitializerController.class.getName();

	private InitializerFragmentView view;
	private InitializerModel model;

	public InitializerController(InitializerFragmentView view, InitializerModel model) {
		this.view = view;
		this.model = model;
	}

	public void addName() {
		String name = model.getName().getText().toString();
		Logger.info(TAG, "The name is %s.", name);

		requireNonEmpty(name, view, R.string.error_invalid_name);

		ApplicationConfig.store(ConfigEnum.NAME, name);
		goToFragment(FragmentEnum.FRAGMENT_CURRENCY, view.getActivity());
	}
}