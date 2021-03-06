package net.anotheria.moskito.webui;

import net.anotheria.maf.action.ActionForward;
import net.anotheria.maf.action.ActionMappings;
import net.anotheria.maf.action.ActionMappingsConfigurator;
import net.anotheria.maf.action.CommandRedirect;
import net.anotheria.moskito.webui.accumulators.action.CreateAccumulatorAction;
import net.anotheria.moskito.webui.accumulators.action.DeleteAccumulatorAction;
import net.anotheria.moskito.webui.accumulators.action.GenerateChartAction;
import net.anotheria.moskito.webui.accumulators.action.ShowAccumulatorsAction;
import net.anotheria.moskito.webui.auth.actions.SignInAction;
import net.anotheria.moskito.webui.auth.actions.SignOutAction;
import net.anotheria.moskito.webui.dashboards.action.*;
import net.anotheria.moskito.webui.gauges.action.ShowGaugesAction;
import net.anotheria.moskito.webui.journey.action.*;
import net.anotheria.moskito.webui.more.action.*;
import net.anotheria.moskito.webui.plugins.action.RemovePluginAction;
import net.anotheria.moskito.webui.plugins.action.ShowPluginsAction;
import net.anotheria.moskito.webui.producers.action.ShowAllProducersAction;
import net.anotheria.moskito.webui.producers.action.ShowProducerAction;
import net.anotheria.moskito.webui.producers.action.ShowProducersForCategoryAction;
import net.anotheria.moskito.webui.producers.action.ShowProducersForSubsystemAction;
import net.anotheria.moskito.webui.shared.action.*;
import net.anotheria.moskito.webui.shared.commands.CommandDeepLinkRedirect;
import net.anotheria.moskito.webui.threads.action.*;
import net.anotheria.moskito.webui.threshold.action.*;
import net.anotheria.moskito.webui.tracers.action.*;

/**
 * Mappings configurator for MoSKito project for the AnoMaf framework.
 * @author lrosenberg.
 *
 */
public class MoskitoMappingsConfigurator implements ActionMappingsConfigurator{
	
	@Override public void configureActionMappings(ActionMappings mappings){

		mappings.addMapping("mskSignIn", SignInAction.class,
				// Default redirect in case user directly pass to login page
				new ActionForward("loginPage", "/net/anotheria/moskito/webui/auth/jsp/Login.jsp"),
				new CommandRedirect("defaultRedirect", "mskDashboard")
		);
		mappings.addMapping("mskSignOut", SignOutAction.class,
				new CommandRedirect("redirect", "mskDashboard")
		);

		mappings.addMapping("mskShowAllProducers", ShowAllProducersAction.class,
				new ActionForward("html", "/net/anotheria/moskito/webui/producers/jsp/Producers.jsp"),
				new ActionForward("xml", "/net/anotheria/moskito/webui/producers/jsp/ProducersXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/producers/jsp/ProducersCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/producers/jsp/ProducersJSON.jsp")
		);

		mappings.addAlias("mskShowAllProducers.csv", "mskShowAllProducers");
		mappings.addAlias("mskShowAllProducers.xml", "mskShowAllProducers");
		mappings.addAlias("mskShowAllProducers.json", "mskShowAllProducers");
 
		mappings.addMapping("mskShowProducersByCategory", ShowProducersForCategoryAction.class,
				new ActionForward("html", "/net/anotheria/moskito/webui/producers/jsp/Producers.jsp"),
				new ActionForward("xml", "/net/anotheria/moskito/webui/producers/jsp/ProducersXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/producers/jsp/ProducersCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/producers/jsp/ProducersJSON.jsp")
		);
		
		mappings.addAlias("mskShowProducersByCategory.csv", "mskShowProducersByCategory");
		mappings.addAlias("mskShowProducersByCategory.xml", "mskShowProducersByCategory");
		mappings.addAlias("mskShowProducersByCategory.json", "mskShowProducersByCategory");

		mappings.addMapping("mskShowProducersBySubsystem", ShowProducersForSubsystemAction.class, 
				new ActionForward("html", "/net/anotheria/moskito/webui/producers/jsp/Producers.jsp"),
		 		new ActionForward("xml", "/net/anotheria/moskito/webui/producers/jsp/ProducersXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/producers/jsp/ProducersCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/producers/jsp/ProducersJSON.jsp")
		);
		
		mappings.addAlias("mskShowProducersBySubsystem.csv", "mskShowProducersBySubsystem");
		mappings.addAlias("mskShowProducersBySubsystem.xml", "mskShowProducersBySubsystem");
		mappings.addAlias("mskShowProducersBySubsystem.json", "mskShowProducersBySubsystem");

		mappings.addMapping("mskShowProducer", ShowProducerAction.class, 
				new ActionForward("html", "/net/anotheria/moskito/webui/producers/jsp/Producer.jsp"),
				new ActionForward("xml", "/net/anotheria/moskito/webui/producers/jsp/ProducerXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/producers/jsp/ProducerCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/shared/jsp/ProducerJSON.jsp")
				//new ActionForward("selection", "/net/anotheria/moskito/webui/producers/jsp/ProducerForSelection.jsp")
		);
		
		mappings.addAlias("mskShowProducer.csv", "mskShowProducer");
		mappings.addAlias("mskShowProducer.xml", "mskShowProducer");
		mappings.addAlias("mskShowProducer.json", "mskShowProducer");
		mappings.addAlias("mskShowProducerForSelection", "mskShowProducer");

		mappings.addMapping("mskShowExplanations", ShowExplanationsAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/shared/jsp/Explanations.jsp")
		);

		mappings.addMapping("mskShowJourneys", ShowJourneysAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/journey/jsp/Journeys.jsp")
		);
		mappings.addMapping("mskShowJourney", ShowJourneyAction.class, 
				new ActionForward("success", "/net/anotheria/moskito/webui/journey/jsp/Journey.jsp")
		);
		mappings.addMapping("mskShowJourneyCall", ShowJourneyCallAction.class, 
				new ActionForward("success", "/net/anotheria/moskito/webui/journey/jsp/JourneyCall.jsp")
		);

		mappings.addMapping("mskDeleteJourney", DeleteJourneyAction.class,
				new CommandDeepLinkRedirect("redirect", "mskShowJourneys")
		);


		mappings.addMapping("mskForceIntervalUpdate", ForceIntervalUpdateAction.class);

		mappings.addMapping("mskThresholds", ShowThresholdsAction.class,
				new ActionForward("html", "/net/anotheria/moskito/webui/threshold/jsp/Thresholds.jsp"),
				new ActionForward("xml", "/net/anotheria/moskito/webui/threshold/jsp/ThresholdsXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/threshold/jsp/ThresholdsCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/threshold/jsp/ThresholdsJSON.jsp")
		);
		mappings.addAlias("mskThresholds.csv", "mskThresholds");
		mappings.addAlias("mskThresholds.xml", "mskThresholds");
		mappings.addAlias("mskThresholds.json", "mskThresholds");

		//mappings.addMapping("mskThresholdEdit", EditThresholdAction.class,
		//		new ActionForward("success", "/net/anotheria/moskito/webui/threshold/jsp/EditThreshold.jsp")
		//);

		mappings.addMapping("mskThresholdDelete", DeleteThresholdAction.class,
				new CommandDeepLinkRedirect("redirect", "mskThresholds"));
		mappings.addMapping("mskThresholdCreate", CreateThresholdAction.class,
				new CommandDeepLinkRedirect("redirect", "mskShowProducer"));
		mappings.addMapping("mskThresholdUpdate", UpdateThresholdAction.class,
				new CommandDeepLinkRedirect("redirect", "mskThresholds"));


		mappings.addMapping("mskAccumulators", ShowAccumulatorsAction.class,
				new ActionForward("html", "/net/anotheria/moskito/webui/accumulators/jsp/Accumulators.jsp"),
				new ActionForward("xml", "/net/anotheria/moskito/webui/accumulators/jsp/AccumulatorsXML.jsp"),
				new ActionForward("csv", "/net/anotheria/moskito/webui/accumulators/jsp/AccumulatorsCSV.jsp"),
				new ActionForward("json", "/net/anotheria/moskito/webui/accumulators/jsp/AccumulatorsJSON.jsp")
		);
		mappings.addAlias("mskAccumulators.csv", "mskAccumulators");
		mappings.addAlias("mskAccumulators.xml", "mskAccumulators");
		mappings.addAlias("mskAccumulators.json", "mskAccumulators");
		
		mappings.addMapping("mskAccumulatorDelete", DeleteAccumulatorAction.class,
                new CommandRedirect("redirect", "mskAccumulators"));
		mappings.addMapping("mskAccumulatorCreate", CreateAccumulatorAction.class,
				new CommandRedirect("redirect", "mskShowProducer"));


		//gauges, now just for testing purposes
		mappings.addMapping("mskGauges", ShowGaugesAction.class,
			new ActionForward("success", "/net/anotheria/moskito/webui/gauges/jsp/Gauges.jsp"));
		mappings.addMapping("mskGenerateChart", GenerateChartAction.class);

		//tracers
		mappings.addMapping("mskTracers", ShowTracersAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/tracers/jsp/Tracers.jsp"));
		mappings.addMapping("mskTracer", ShowTracerAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/tracers/jsp/Tracer.jsp"));

		mappings.addMapping("mskCreateTracer", CreateTracerAction.class);
		mappings.addMapping("mskRemoveTracer", RemoveTracerAction.class,
				new CommandDeepLinkRedirect("redirect", "mskTracers"));
		mappings.addMapping("mskDisableTracer", DisableTracerAction.class,
				new CommandDeepLinkRedirect("redirect", "mskTracers"));
		mappings.addMapping("mskEnableTracer", EnableTracerAction.class,
				new CommandDeepLinkRedirect("redirect", "mskTracers"));



		//analyze journey
		mappings.addMapping("mskAnalyzeJourney", AnalyzeJourneyAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/journey/jsp/AnalyzeJourney.jsp")
		);
		
		//threads
		mappings.addMapping("mskThreads", ThreadsOverviewAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/Threads.jsp"));
		mappings.addMapping("mskThreadsList", ThreadsListAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsList.jsp"));
		mappings.addMapping("mskThreadsDump", ThreadsDumpAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsDump.jsp"));
		mappings.addMapping("mskThreadsHistory", ThreadsHistoryAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsHistory.jsp"));
		//hidden features.
		mappings.addMapping("mskThreadsSetHistoryListSize", SetHistoryListSizeAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsHistory.jsp"));
		mappings.addMapping("mskThreadsStartTestThread", StartThreadAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsHistory.jsp"));
		mappings.addMapping("mskThreadsHistoryOff", HistoryOffAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsHistory.jsp"));
		mappings.addMapping("mskThreadsHistoryOn", HistoryOnAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/threads/jsp/ThreadsHistory.jsp"));

		//additional information section
		mappings.addMapping("mskMore", AdditionalSectionAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/AdditionalItems.jsp")
		);
		mappings.addMapping("mskConfig", ShowConfigAction.class,
			new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Config.jsp")
		);
		mappings.addMapping("mskErrors", ShowErrorsAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Errors.jsp")
		);
		mappings.addMapping("mskError", ShowErrorAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Error.jsp")
		);
		mappings.addMapping("mskLibs", ShowLibsAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Libs.jsp")
		);
		mappings.addMapping("mskMBeans", ShowMBeansAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/MBeans.jsp")
		);
		mappings.addMapping("mskPlugins", ShowPluginsAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Plugins.jsp")
		);

		mappings.addMapping("mskRemovePlugin", RemovePluginAction.class,
				new CommandDeepLinkRedirect("redirect", "mskPlugins")
		);

		mappings.addMapping("mskSelectServer", SelectServerAction.class,
			new CommandDeepLinkRedirect("redirect", "mskShowAllProducers")
		);

		mappings.addMapping("mskQuickConnect", QuickConnectAction.class,
				new CommandDeepLinkRedirect("redirect", "mskShowAllProducers")
		);


		mappings.addMapping("mskUpdate", UpdateAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/more/jsp/Update.jsp")
		);

		// ajax
		mappings.addMapping("mskSaveNavMenuState", SaveNavMenuStateAction.class);
		mappings.addMapping("mskGetExplanationsByName", GetExplanationsByDecoratorNameAction.class);
		mappings.addMapping("mskGetThresholdDefinition", GetThresholdDefinitionAction.class);

		//errors
		mappings.setOnError(new ActionForward("error", "/net/anotheria/moskito/webui/shared/jsp/Error.jsp"));

		//dashboards
		mappings.addMapping("mskDashboard", ShowDashboardAction.class,
				new ActionForward("success", "/net/anotheria/moskito/webui/dashboards/jsp/Dashboard.jsp")
		);
		mappings.addMapping("mskCreateDashboard", CreateDashboardAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));
		mappings.addMapping("mskDeleteDashboard", DeleteDashboardAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));

		mappings.addMapping("mskAddGaugeToDashboard", DashboardAddGaugeAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));
		mappings.addMapping("mskDashboardRemoveGauge", DashboardRemoveGaugeAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));

		mappings.addMapping("mskAddThresholdToDashboard", DashboardAddThresholdAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));
		mappings.addMapping("mskDashboardRemoveThreshold", DashboardRemoveThresholdAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));

		mappings.addMapping("mskAddChartToDashboard", DashboardAddChartAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));
		mappings.addMapping("mskDashboardRemoveChart", DashboardRemoveChartAction.class,
				new CommandDeepLinkRedirect("redirect", "mskDashboard"));


	}

}
