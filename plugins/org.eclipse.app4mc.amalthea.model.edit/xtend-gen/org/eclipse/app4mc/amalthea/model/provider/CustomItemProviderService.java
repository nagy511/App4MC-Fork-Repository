package org.eclipse.app4mc.amalthea.model.provider;

import com.google.common.base.Objects;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.app4mc.amalthea.model.AbstractElementMapping;
import org.eclipse.app4mc.amalthea.model.AbstractElementMappingConstraint;
import org.eclipse.app4mc.amalthea.model.AbstractElementMemoryInformation;
import org.eclipse.app4mc.amalthea.model.AbstractProcess;
import org.eclipse.app4mc.amalthea.model.AbstractTime;
import org.eclipse.app4mc.amalthea.model.AccessPathRef;
import org.eclipse.app4mc.amalthea.model.AccessPrecedenceSpec;
import org.eclipse.app4mc.amalthea.model.AccessPrecedenceType;
import org.eclipse.app4mc.amalthea.model.AmaltheaPackage;
import org.eclipse.app4mc.amalthea.model.ArchitectureRequirement;
import org.eclipse.app4mc.amalthea.model.ArrivalCurveEntry;
import org.eclipse.app4mc.amalthea.model.AsynchronousServerCall;
import org.eclipse.app4mc.amalthea.model.BaseTypeDefinition;
import org.eclipse.app4mc.amalthea.model.BigIntegerObject;
import org.eclipse.app4mc.amalthea.model.BooleanObject;
import org.eclipse.app4mc.amalthea.model.CPUPercentageMetric;
import org.eclipse.app4mc.amalthea.model.CPUPercentageRequirementLimit;
import org.eclipse.app4mc.amalthea.model.ChainedProcessPrototype;
import org.eclipse.app4mc.amalthea.model.Channel;
import org.eclipse.app4mc.amalthea.model.ChannelAccess;
import org.eclipse.app4mc.amalthea.model.ChannelReceive;
import org.eclipse.app4mc.amalthea.model.ChannelSend;
import org.eclipse.app4mc.amalthea.model.ClearEvent;
import org.eclipse.app4mc.amalthea.model.CoherencyDirection;
import org.eclipse.app4mc.amalthea.model.ComplexNode;
import org.eclipse.app4mc.amalthea.model.ComplexPort;
import org.eclipse.app4mc.amalthea.model.Component;
import org.eclipse.app4mc.amalthea.model.ComponentInstance;
import org.eclipse.app4mc.amalthea.model.ComponentScope;
import org.eclipse.app4mc.amalthea.model.Composite;
import org.eclipse.app4mc.amalthea.model.Connector;
import org.eclipse.app4mc.amalthea.model.Core;
import org.eclipse.app4mc.amalthea.model.CoreAllocation;
import org.eclipse.app4mc.amalthea.model.CoreType;
import org.eclipse.app4mc.amalthea.model.CountMetric;
import org.eclipse.app4mc.amalthea.model.CountRequirementLimit;
import org.eclipse.app4mc.amalthea.model.DataAgeCycle;
import org.eclipse.app4mc.amalthea.model.DataAgeTime;
import org.eclipse.app4mc.amalthea.model.DataCoherencyGroup;
import org.eclipse.app4mc.amalthea.model.DataGroupScope;
import org.eclipse.app4mc.amalthea.model.DataPlatformMapping;
import org.eclipse.app4mc.amalthea.model.DataSize;
import org.eclipse.app4mc.amalthea.model.DataSizeUnit;
import org.eclipse.app4mc.amalthea.model.DataStability;
import org.eclipse.app4mc.amalthea.model.DataTypeDefinition;
import org.eclipse.app4mc.amalthea.model.Deviation;
import org.eclipse.app4mc.amalthea.model.Distribution;
import org.eclipse.app4mc.amalthea.model.DoubleObject;
import org.eclipse.app4mc.amalthea.model.EntityEvent;
import org.eclipse.app4mc.amalthea.model.EventChain;
import org.eclipse.app4mc.amalthea.model.EventChainReference;
import org.eclipse.app4mc.amalthea.model.EventConfigElement;
import org.eclipse.app4mc.amalthea.model.EventConfigLink;
import org.eclipse.app4mc.amalthea.model.FInterfacePort;
import org.eclipse.app4mc.amalthea.model.FloatObject;
import org.eclipse.app4mc.amalthea.model.Frequency;
import org.eclipse.app4mc.amalthea.model.FrequencyMetric;
import org.eclipse.app4mc.amalthea.model.FrequencyRequirementLimit;
import org.eclipse.app4mc.amalthea.model.FrequencyUnit;
import org.eclipse.app4mc.amalthea.model.Group;
import org.eclipse.app4mc.amalthea.model.HwAccessPath;
import org.eclipse.app4mc.amalthea.model.HwAccessPathRef;
import org.eclipse.app4mc.amalthea.model.HwElementRef;
import org.eclipse.app4mc.amalthea.model.ISR;
import org.eclipse.app4mc.amalthea.model.ISRAllocation;
import org.eclipse.app4mc.amalthea.model.Instructions;
import org.eclipse.app4mc.amalthea.model.InstructionsConstant;
import org.eclipse.app4mc.amalthea.model.InstructionsDeviation;
import org.eclipse.app4mc.amalthea.model.IntegerObject;
import org.eclipse.app4mc.amalthea.model.InterProcessActivation;
import org.eclipse.app4mc.amalthea.model.InterfaceKind;
import org.eclipse.app4mc.amalthea.model.InterruptController;
import org.eclipse.app4mc.amalthea.model.Label;
import org.eclipse.app4mc.amalthea.model.LabelAccess;
import org.eclipse.app4mc.amalthea.model.LabelAccessEnum;
import org.eclipse.app4mc.amalthea.model.LatencyAccessPath;
import org.eclipse.app4mc.amalthea.model.LatencyConstant;
import org.eclipse.app4mc.amalthea.model.LatencyDeviation;
import org.eclipse.app4mc.amalthea.model.LimitType;
import org.eclipse.app4mc.amalthea.model.LongObject;
import org.eclipse.app4mc.amalthea.model.Memory;
import org.eclipse.app4mc.amalthea.model.MinAvgMaxStatistic;
import org.eclipse.app4mc.amalthea.model.Mode;
import org.eclipse.app4mc.amalthea.model.ModeLabel;
import org.eclipse.app4mc.amalthea.model.ModeLabelAccess;
import org.eclipse.app4mc.amalthea.model.ModeLiteral;
import org.eclipse.app4mc.amalthea.model.ModeSwitch;
import org.eclipse.app4mc.amalthea.model.ModeSwitchEntry;
import org.eclipse.app4mc.amalthea.model.ModeValueList;
import org.eclipse.app4mc.amalthea.model.ModeValueListEntry;
import org.eclipse.app4mc.amalthea.model.ModeValueProvider;
import org.eclipse.app4mc.amalthea.model.NonAtomicDataCoherency;
import org.eclipse.app4mc.amalthea.model.OrderPrecedenceSpec;
import org.eclipse.app4mc.amalthea.model.OrderType;
import org.eclipse.app4mc.amalthea.model.OsAPIInstructions;
import org.eclipse.app4mc.amalthea.model.OsDataConsistency;
import org.eclipse.app4mc.amalthea.model.OsDataConsistencyMode;
import org.eclipse.app4mc.amalthea.model.OsISRInstructions;
import org.eclipse.app4mc.amalthea.model.OsInstructions;
import org.eclipse.app4mc.amalthea.model.PercentageMetric;
import org.eclipse.app4mc.amalthea.model.PercentageRequirementLimit;
import org.eclipse.app4mc.amalthea.model.PhysicalSectionConstraint;
import org.eclipse.app4mc.amalthea.model.PhysicalSectionMapping;
import org.eclipse.app4mc.amalthea.model.Port;
import org.eclipse.app4mc.amalthea.model.ProcessAllocationConstraint;
import org.eclipse.app4mc.amalthea.model.ProcessChain;
import org.eclipse.app4mc.amalthea.model.ProcessChainRequirement;
import org.eclipse.app4mc.amalthea.model.ProcessPrototype;
import org.eclipse.app4mc.amalthea.model.ProcessPrototypeAllocationConstraint;
import org.eclipse.app4mc.amalthea.model.ProcessRequirement;
import org.eclipse.app4mc.amalthea.model.ProcessScope;
import org.eclipse.app4mc.amalthea.model.QualifiedPort;
import org.eclipse.app4mc.amalthea.model.RWType;
import org.eclipse.app4mc.amalthea.model.RunnableAllocation;
import org.eclipse.app4mc.amalthea.model.RunnableAllocationConstraint;
import org.eclipse.app4mc.amalthea.model.RunnableCall;
import org.eclipse.app4mc.amalthea.model.RunnableInstructions;
import org.eclipse.app4mc.amalthea.model.RunnableItem;
import org.eclipse.app4mc.amalthea.model.RunnableModeSwitch;
import org.eclipse.app4mc.amalthea.model.RunnableProbabilitySwitch;
import org.eclipse.app4mc.amalthea.model.RunnableRequirement;
import org.eclipse.app4mc.amalthea.model.RunnableScope;
import org.eclipse.app4mc.amalthea.model.Scheduler;
import org.eclipse.app4mc.amalthea.model.Section;
import org.eclipse.app4mc.amalthea.model.Semaphore;
import org.eclipse.app4mc.amalthea.model.SemaphoreAccess;
import org.eclipse.app4mc.amalthea.model.SemaphoreAccessEnum;
import org.eclipse.app4mc.amalthea.model.SenderReceiverRead;
import org.eclipse.app4mc.amalthea.model.SenderReceiverWrite;
import org.eclipse.app4mc.amalthea.model.SetEvent;
import org.eclipse.app4mc.amalthea.model.SignedTime;
import org.eclipse.app4mc.amalthea.model.SignedTimeObject;
import org.eclipse.app4mc.amalthea.model.SingleValueStatistic;
import org.eclipse.app4mc.amalthea.model.Stimulus;
import org.eclipse.app4mc.amalthea.model.StringObject;
import org.eclipse.app4mc.amalthea.model.SubEventChain;
import org.eclipse.app4mc.amalthea.model.SynchronousServerCall;
import org.eclipse.app4mc.amalthea.model.Tag;
import org.eclipse.app4mc.amalthea.model.TagGroup;
import org.eclipse.app4mc.amalthea.model.Task;
import org.eclipse.app4mc.amalthea.model.TaskAllocation;
import org.eclipse.app4mc.amalthea.model.TaskRunnableCall;
import org.eclipse.app4mc.amalthea.model.TaskScheduler;
import org.eclipse.app4mc.amalthea.model.Time;
import org.eclipse.app4mc.amalthea.model.TimeMetric;
import org.eclipse.app4mc.amalthea.model.TimeObject;
import org.eclipse.app4mc.amalthea.model.TimeRequirementLimit;
import org.eclipse.app4mc.amalthea.model.TimeUnit;
import org.eclipse.app4mc.amalthea.model.TransmissionPolicy;
import org.eclipse.app4mc.amalthea.model.TypeDefinition;
import org.eclipse.app4mc.amalthea.model.TypeRef;
import org.eclipse.app4mc.amalthea.model.Value;
import org.eclipse.app4mc.amalthea.model.WaitEvent;
import org.eclipse.app4mc.amalthea.model.WaitingBehaviour;
import org.eclipse.app4mc.amalthea.model.impl.CustomPropertyImpl;
import org.eclipse.app4mc.amalthea.model.impl.RunnableInstructionsEntryImpl;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CustomItemProviderService {
  private static String getContainingFeatureName(final EObject object, final String defaultText, final String separator) {
    EStructuralFeature _eContainingFeature = null;
    if (object!=null) {
      _eContainingFeature=object.eContainingFeature();
    }
    final EStructuralFeature feature = _eContainingFeature;
    String _xifexpression = null;
    boolean _equals = Objects.equal(feature, null);
    if (_equals) {
      _xifexpression = defaultText;
    } else {
      String _name = feature.getName();
      _xifexpression = (_name + separator);
    }
    final String name = _xifexpression;
    return name;
  }
  
  private static String getContainingFeatureName(final EObject object) {
    return CustomItemProviderService.getContainingFeatureName(object, "", ": ");
  }
  
  private static String getLabelProviderText(final Object object, final AdapterFactory rootAF) {
    if (((!Objects.equal(object, null)) && rootAF.isFactoryForType(object))) {
      final Object plainAdapter = rootAF.adapt(object, IItemLabelProvider.class);
      if ((plainAdapter instanceof IItemLabelProvider)) {
        return ((IItemLabelProvider)plainAdapter).getText(object);
      }
    }
    return "";
  }
  
  private static String getFrequencyText(final Frequency frequency) {
    boolean _equals = Objects.equal(frequency, null);
    if (_equals) {
      return "<frequency>";
    }
    double _value = frequency.getValue();
    final String value = Double.toString(_value);
    String _xifexpression = null;
    FrequencyUnit _unit = frequency.getUnit();
    boolean _equals_1 = Objects.equal(_unit, FrequencyUnit._UNDEFINED_);
    if (_equals_1) {
      _xifexpression = "<unit>";
    } else {
      FrequencyUnit _unit_1 = frequency.getUnit();
      _xifexpression = _unit_1.getLiteral();
    }
    final String unit = _xifexpression;
    return ((value + " ") + unit);
  }
  
  private static String getTimeText(final AbstractTime time) {
    boolean _equals = Objects.equal(time, null);
    if (_equals) {
      return "<time>";
    }
    int _value = time.getValue();
    final String value = Integer.toString(_value);
    String _xifexpression = null;
    TimeUnit _unit = time.getUnit();
    boolean _equals_1 = Objects.equal(_unit, TimeUnit._UNDEFINED_);
    if (_equals_1) {
      _xifexpression = "<unit>";
    } else {
      TimeUnit _unit_1 = time.getUnit();
      _xifexpression = _unit_1.getLiteral();
    }
    final String unit = _xifexpression;
    return ((value + " ") + unit);
  }
  
  private static String getDataSizeText(final DataSize size) {
    boolean _equals = Objects.equal(size, null);
    if (_equals) {
      return "<data size>";
    }
    String _xifexpression = null;
    BigInteger _value = size.getValue();
    boolean _equals_1 = Objects.equal(_value, null);
    if (_equals_1) {
      _xifexpression = "???";
    } else {
      BigInteger _value_1 = size.getValue();
      _xifexpression = _value_1.toString();
    }
    final String value = _xifexpression;
    String _xifexpression_1 = null;
    DataSizeUnit _unit = size.getUnit();
    boolean _equals_2 = Objects.equal(_unit, DataSizeUnit._UNDEFINED_);
    if (_equals_2) {
      _xifexpression_1 = "<unit>";
    } else {
      DataSizeUnit _unit_1 = size.getUnit();
      _xifexpression_1 = _unit_1.getLiteral();
    }
    final String unit = _xifexpression_1;
    return ((value + " ") + unit);
  }
  
  private static String trimDistName(final String name) {
    boolean _equals = Objects.equal(name, null);
    if (_equals) {
      return "";
    }
    String _replace = name.replace("Distribution", "");
    String _replace_1 = _replace.replace("Estimators", "");
    return _replace_1.replace("Parameters", "");
  }
  
  private static String getInstructionsText(final Instructions instr) {
    String _switchResult = null;
    boolean _matched = false;
    if (instr instanceof InstructionsConstant) {
      _matched=true;
      _switchResult = CustomItemProviderService.getInstructionsConstantItemProviderText(instr, null);
    }
    if (!_matched) {
      if (instr instanceof InstructionsDeviation) {
        _matched=true;
        _switchResult = CustomItemProviderService.getInstructionsDeviationItemProviderText(instr, null);
      }
    }
    return _switchResult;
  }
  
  /**
   * CustomPropertyItemProvider
   */
  public static String getCustomPropertyItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof CustomPropertyImpl)) {
      String _key = null;
      if (((CustomPropertyImpl)object)!=null) {
        _key=((CustomPropertyImpl)object).getKey();
      }
      final String key = _key;
      Value _value = null;
      if (((CustomPropertyImpl)object)!=null) {
        _value=((CustomPropertyImpl)object).getValue();
      }
      final Value value = _value;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(key);
      if (_isNullOrEmpty) {
        _xifexpression = "<key>";
      } else {
        _xifexpression = (("\"" + key) + "\"");
      }
      final String s1 = _xifexpression;
      Object _xifexpression_1 = null;
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
        _xifexpression_1 = "null";
      } else {
        _xifexpression_1 = value;
      }
      final Object s2 = _xifexpression_1;
      return ((s1 + " -> ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getCustomPropertyItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(Map.Entry.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.CUSTOM_PROPERTY__KEY)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CUSTOM_PROPERTY__VALUE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * BooleanObjectItemProvider
   */
  public static String getBooleanObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof BooleanObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + object);
    } else {
      return defaultText;
    }
  }
  
  /**
   * DoubleObjectItemProvider
   */
  public static String getDoubleObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DoubleObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + object);
    } else {
      return defaultText;
    }
  }
  
  /**
   * FloatObjectItemProvider
   */
  public static String getFloatObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof FloatObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + object);
    } else {
      return defaultText;
    }
  }
  
  /**
   * IntegerObjectItemProvider
   */
  public static String getIntegerObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof IntegerObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + object);
    } else {
      return defaultText;
    }
  }
  
  /**
   * LongObjectItemProvider
   */
  public static String getLongObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof LongObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + object);
    } else {
      return defaultText;
    }
  }
  
  /**
   * SignedTimeObjectItemProvider
   */
  public static String getSignedTimeObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SignedTimeObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _timeText = CustomItemProviderService.getTimeText(((AbstractTime)object));
      return (_containingFeatureName + _timeText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * TimeObjectItemProvider
   */
  public static String getTimeObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TimeObject)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _timeText = CustomItemProviderService.getTimeText(((AbstractTime)object));
      return (_containingFeatureName + _timeText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * StringObjectItemProvider
   */
  public static String getStringObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof StringObject)) {
      final String s1 = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _xifexpression = null;
      String _value = null;
      if (((StringObject)object)!=null) {
        _value=((StringObject)object).getValue();
      }
      boolean _equals = Objects.equal(_value, null);
      if (_equals) {
        _xifexpression = "null";
      } else {
        String _value_1 = ((StringObject)object).getValue();
        String _plus = ("\"" + _value_1);
        _xifexpression = (_plus + "\"");
      }
      final String s2 = _xifexpression;
      return (s1 + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * BigIntegerObjectItemProvider
   */
  public static String getBigIntegerObjectItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof BigIntegerObject)) {
      final String s1 = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _xifexpression = null;
      BigInteger _value = null;
      if (((BigIntegerObject)object)!=null) {
        _value=((BigIntegerObject)object).getValue();
      }
      boolean _equals = Objects.equal(_value, null);
      if (_equals) {
        _xifexpression = "null";
      } else {
        BigInteger _value_1 = ((BigIntegerObject)object).getValue();
        String _plus = ("\"" + _value_1);
        _xifexpression = (_plus + "\"");
      }
      final String s2 = _xifexpression;
      return (s1 + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * BoundariesItemProvider
   */
  public static String getBoundariesItemProviderText(final Object object, final String defaultText) {
    return "Dist: Boundaries";
  }
  
  /**
   * BetaDistributionItemProvider
   */
  public static String getBetaDistributionItemProviderText(final Object object, final String defaultText) {
    return "Dist: Beta";
  }
  
  /**
   * GaussDistributionItemProvider
   */
  public static String getGaussDistributionItemProviderText(final Object object, final String defaultText) {
    return "Dist: Gauss";
  }
  
  /**
   * UniformDistributionItemProvider
   */
  public static String getUniformDistributionItemProviderText(final Object object, final String defaultText) {
    return "Dist: Uniform";
  }
  
  /**
   * WeibullEstimatorsItemProvider
   */
  public static String getWeibullEstimatorsItemProviderText(final Object object, final String defaultText) {
    return "Dist: Weibull Estimators";
  }
  
  /**
   * WeibullParametersItemProvider
   */
  public static String getWeibullParametersItemProviderText(final Object object, final String defaultText) {
    return "Dist: Weibull Parameters";
  }
  
  /**
   * FrequencyItemProvider
   */
  public static String getFrequencyItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Frequency)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _frequencyText = CustomItemProviderService.getFrequencyText(((Frequency)object));
      return (_containingFeatureName + _frequencyText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * DataSizeItemProvider
   */
  public static String getDataSizeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataSize)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _dataSizeText = CustomItemProviderService.getDataSizeText(((DataSize)object));
      return (_containingFeatureName + _dataSizeText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * DeviationItemProvider
   */
  public static String getDeviationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Deviation<?>)) {
      Distribution<?> _distribution = null;
      if (((Deviation<?>)object)!=null) {
        _distribution=((Deviation<?>)object).getDistribution();
      }
      EClass _eClass = null;
      if (_distribution!=null) {
        _eClass=_distribution.eClass();
      }
      String _name = null;
      if (_eClass!=null) {
        _name=_eClass.getName();
      }
      final String distName = _name;
      Object _lowerBound = null;
      if (((Deviation<?>)object)!=null) {
        _lowerBound=((Deviation<?>)object).getLowerBound();
      }
      final Object lower = _lowerBound;
      Object _upperBound = null;
      if (((Deviation<?>)object)!=null) {
        _upperBound=((Deviation<?>)object).getUpperBound();
      }
      final Object upper = _upperBound;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(distName);
      if (_isNullOrEmpty) {
        _xifexpression = "Dist: ???";
      } else {
        String _trimDistName = CustomItemProviderService.trimDistName(distName);
        _xifexpression = ("Dist: " + _trimDistName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _equals = Objects.equal(lower, null);
      if (_equals) {
        _xifexpression_1 = "";
      } else {
        _xifexpression_1 = (" lowerBound: " + lower);
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _equals_1 = Objects.equal(upper, null);
      if (_equals_1) {
        _xifexpression_2 = "";
      } else {
        _xifexpression_2 = (" upperBound: " + upper);
      }
      final String s3 = _xifexpression_2;
      return ((s1 + s2) + s3);
    }
    return null;
  }
  
  public static List<ViewerNotification> getDeviationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(Deviation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.DEVIATION__LOWER_BOUND)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DEVIATION__UPPER_BOUND)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DEVIATION__DISTRIBUTION)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, true, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * MinAvgMaxStatisticItemProvider
   */
  public static String getMinAvgMaxStatisticItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof MinAvgMaxStatistic)) {
      final String s1 = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      int _min = ((MinAvgMaxStatistic)object).getMin();
      String _plus = (s1 + Integer.valueOf(_min));
      String _plus_1 = (_plus + " : ");
      int _avg = ((MinAvgMaxStatistic)object).getAvg();
      String _plus_2 = (_plus_1 + Integer.valueOf(_avg));
      String _plus_3 = (_plus_2 + " : ");
      int _max = ((MinAvgMaxStatistic)object).getMax();
      return (_plus_3 + Integer.valueOf(_max));
    } else {
      return defaultText;
    }
  }
  
  /**
   * SingleValueStatisticItemProvider
   */
  public static String getSingleValueStatisticItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SingleValueStatistic)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      float _value = ((SingleValueStatistic)object).getValue();
      return (_containingFeatureName + Float.valueOf(_value));
    } else {
      return defaultText;
    }
  }
  
  /**
   * SignedTimeItemProvider
   */
  public static String getSignedTimeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SignedTime)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _timeText = CustomItemProviderService.getTimeText(((AbstractTime)object));
      return (_containingFeatureName + _timeText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * TimeItemProvider
   */
  public static String getTimeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Time)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _timeText = CustomItemProviderService.getTimeText(((AbstractTime)object));
      return (_containingFeatureName + _timeText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * InstructionsConstantItemProvider
   */
  public static String getInstructionsConstantItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof InstructionsConstant)) {
      final String feature = CustomItemProviderService.getContainingFeatureName(((EObject)object), "", "");
      String _xifexpression = null;
      boolean _equals = Objects.equal(feature, "value");
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = (feature + " -- ");
      }
      final String s1 = _xifexpression;
      long _value = ((InstructionsConstant)object).getValue();
      final String s2 = Long.toString(_value);
      return ((s1 + "instructions (constant): ") + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * InstructionsDeviationItemProvider
   */
  public static String getInstructionsDeviationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof InstructionsDeviation)) {
      final String feature = CustomItemProviderService.getContainingFeatureName(((EObject)object), "", "");
      String _xifexpression = null;
      boolean _equals = Objects.equal(feature, "value");
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = (feature + " -- ");
      }
      final String s1 = _xifexpression;
      Deviation<LongObject> _deviation = null;
      if (((InstructionsDeviation)object)!=null) {
        _deviation=((InstructionsDeviation)object).getDeviation();
      }
      Distribution<LongObject> _distribution = null;
      if (_deviation!=null) {
        _distribution=_deviation.getDistribution();
      }
      EClass _eClass = null;
      if (_distribution!=null) {
        _eClass=_distribution.eClass();
      }
      String _name = null;
      if (_eClass!=null) {
        _name=_eClass.getName();
      }
      final String distName = _name;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(distName);
      if (_isNullOrEmpty) {
        _xifexpression_1 = "<distribution>";
      } else {
        _xifexpression_1 = CustomItemProviderService.trimDistName(distName);
      }
      final String s2 = _xifexpression_1;
      return ((s1 + "instructions (deviation): ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getInstructionsDeviationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(InstructionsDeviation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.INSTRUCTIONS_DEVIATION__DEVIATION)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, true, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * TransmissionPolicyItemProvider
   */
  public static String getTransmissionPolicyItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TransmissionPolicy)) {
      final DataSize size = ((TransmissionPolicy)object).getChunkSize();
      final int instr = ((TransmissionPolicy)object).getChunkProcessingInstructions();
      final double ratio = ((TransmissionPolicy)object).getTransmitRatio();
      String _dataSizeText = CustomItemProviderService.getDataSizeText(size);
      String _plus = ("transmission (chunk size: " + _dataSizeText);
      String _plus_1 = (_plus + " instructions: ");
      String _plus_2 = (_plus_1 + Integer.valueOf(instr));
      String _plus_3 = (_plus_2 + " ratio: ");
      String _plus_4 = (_plus_3 + Double.valueOf(ratio));
      return (_plus_4 + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTransmissionPolicyItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TransmissionPolicy.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TRANSMISSION_POLICY__CHUNK_PROCESSING_INSTRUCTIONS)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.TRANSMISSION_POLICY__TRANSMIT_RATIO)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DATA_SIZE__VALUE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DATA_SIZE__UNIT)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.TRANSMISSION_POLICY__CHUNK_SIZE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ComponentItemProvider
   */
  public static String getComponentItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Component)) {
      String _name = null;
      if (((Component)object)!=null) {
        _name=((Component)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<component>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * ComponentInstanceItemProvider
   */
  public static String getComponentInstanceItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ComponentInstance)) {
      String _name = null;
      if (((ComponentInstance)object)!=null) {
        _name=((ComponentInstance)object).getName();
      }
      final String name = _name;
      Component _type = null;
      if (((ComponentInstance)object)!=null) {
        _type=((ComponentInstance)object).getType();
      }
      String _name_1 = null;
      if (_type!=null) {
        _name_1=_type.getName();
      }
      final String typeName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<component instance>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(typeName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "???";
      } else {
        _xifexpression_1 = typeName;
      }
      final String s2 = _xifexpression_1;
      return (((s1 + " (type: ") + s2) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getComponentInstanceItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ComponentInstance.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.COMPONENT_INSTANCE__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.COMPONENT_INSTANCE__TYPE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.COMPONENT_INSTANCE__CUSTOM_PROPERTIES)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * CompositeItemProvider
   */
  public static String getCompositeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Composite)) {
      String _name = null;
      if (((Composite)object)!=null) {
        _name=((Composite)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<composite>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * ConnectorItemProvider
   */
  public static String getConnectorItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Connector)) {
      String _name = null;
      if (((Connector)object)!=null) {
        _name=((Connector)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<connector>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * FInterfacePortItemProvider
   */
  public static String getFInterfacePortItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof FInterfacePort)) {
      EObject _eContainer = null;
      if (((FInterfacePort)object)!=null) {
        _eContainer=((FInterfacePort)object).eContainer();
      }
      final String cName = ((Component) _eContainer).getName();
      InterfaceKind _kind = null;
      if (((FInterfacePort)object)!=null) {
        _kind=((FInterfacePort)object).getKind();
      }
      final InterfaceKind kind = _kind;
      String _name = null;
      if (((FInterfacePort)object)!=null) {
        _name=((FInterfacePort)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(cName);
      if (_isNullOrEmpty) {
        _xifexpression = "<component>";
      } else {
        _xifexpression = cName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(kind, null) || Objects.equal(kind, InterfaceKind._UNDEFINED_))) {
        _xifexpression_1 = "<kind>";
      } else {
        _xifexpression_1 = kind.getLiteral();
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty_1) {
        _xifexpression_2 = "<port>";
      } else {
        _xifexpression_2 = name;
      }
      final String s3 = _xifexpression_2;
      return ((((s1 + " ") + s2) + " ") + s3);
    } else {
      return defaultText;
    }
  }
  
  /**
   * QualifiedPortItemProvider
   */
  public static String getQualifiedPortItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof QualifiedPort)) {
      ComponentInstance _instance = null;
      if (((QualifiedPort)object)!=null) {
        _instance=((QualifiedPort)object).getInstance();
      }
      String _name = null;
      if (_instance!=null) {
        _name=_instance.getName();
      }
      final String instName = _name;
      Port _port = null;
      if (((QualifiedPort)object)!=null) {
        _port=((QualifiedPort)object).getPort();
      }
      String _name_1 = null;
      if (_port!=null) {
        _name_1=_port.getName();
      }
      final String portName = _name_1;
      String s2 = "";
      String s4 = "";
      ComponentInstance _instance_1 = null;
      if (((QualifiedPort)object)!=null) {
        _instance_1=((QualifiedPort)object).getInstance();
      }
      boolean _equals = Objects.equal(_instance_1, null);
      if (_equals) {
        s4 = " (enclosing composite)";
      } else {
        String _xifexpression = null;
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(instName);
        if (_isNullOrEmpty) {
          _xifexpression = "??? / ";
        } else {
          _xifexpression = (instName + " / ");
        }
        s2 = _xifexpression;
      }
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(portName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<port>";
      } else {
        _xifexpression_1 = portName;
      }
      final String s3 = _xifexpression_1;
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _plus = (_containingFeatureName + s2);
      String _plus_1 = (_plus + s3);
      return (_plus_1 + s4);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getQualifiedPortItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(QualifiedPort.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.QUALIFIED_PORT__INSTANCE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.QUALIFIED_PORT__PORT)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * SystemItemProvider
   */
  public static String getSystemItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof org.eclipse.app4mc.amalthea.model.System)) {
      String _name = null;
      if (((org.eclipse.app4mc.amalthea.model.System)object)!=null) {
        _name=((org.eclipse.app4mc.amalthea.model.System)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<system>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * EventConfigElementItemProvider
   */
  public static String getEventConfigElementItemProviderText(final Object object, final String defaultText, final AdapterFactory rootAF) {
    if ((object instanceof EventConfigElement)) {
      String _name = null;
      if (((EventConfigElement)object)!=null) {
        _name=((EventConfigElement)object).getName();
      }
      final String name = _name;
      EntityEvent _event = null;
      if (((EventConfigElement)object)!=null) {
        _event=((EventConfigElement)object).getEvent();
      }
      final EntityEvent event = _event;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "";
      } else {
        _xifexpression = (name + " ");
      }
      final String s1 = _xifexpression;
      String s2 = CustomItemProviderService.getLabelProviderText(event, rootAF);
      return (((("Config " + s1) + "{") + s2) + "}");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getEventConfigElementItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(EventConfigElement.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.EVENT_CONFIG_ELEMENT__NAME)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.EVENT_CONFIG_ELEMENT__EVENT)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * EventConfigLinkItemProvider
   */
  public static String getEventConfigLinkItemProviderText(final Object object, final String defaultText, final AdapterFactory rootAF) {
    if ((object instanceof EventConfigLink)) {
      String _name = null;
      if (((EventConfigLink)object)!=null) {
        _name=((EventConfigLink)object).getName();
      }
      final String name = _name;
      EntityEvent _event = null;
      if (((EventConfigLink)object)!=null) {
        _event=((EventConfigLink)object).getEvent();
      }
      final EntityEvent event = _event;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "";
      } else {
        _xifexpression = (name + " ");
      }
      final String s1 = _xifexpression;
      String s2 = CustomItemProviderService.getLabelProviderText(event, rootAF);
      return (((("Config Link " + s1) + "{") + s2) + "}");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getEventConfigLinkItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(EventConfigLink.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.EVENT_CONFIG_LINK__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.EVENT_CONFIG_LINK__EVENT)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  private static String getLimitTypeText(final LimitType limitType) {
    String _switchResult = null;
    if (limitType != null) {
      switch (limitType) {
        case UPPER_LIMIT:
          _switchResult = " <= ";
          break;
        case LOWER_LIMIT:
          _switchResult = " >= ";
          break;
        default:
          _switchResult = " ? ";
          break;
      }
    } else {
      _switchResult = " ? ";
    }
    return _switchResult;
  }
  
  /**
   * ComponentScopeItemProvider
   */
  public static String getComponentScopeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ComponentScope)) {
      Component _component = null;
      if (((ComponentScope)object)!=null) {
        _component=((ComponentScope)object).getComponent();
      }
      String _name = null;
      if (_component!=null) {
        _name=_component.getName();
      }
      final String compName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(compName);
      if (_isNullOrEmpty) {
        _xifexpression = "<component>";
      } else {
        _xifexpression = ("Component " + compName);
      }
      final String s1 = _xifexpression;
      return ("Scope: " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getComponentScopeItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ComponentScope.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.COMPONENT_SCOPE__COMPONENT)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ProcessScopeItemProvider
   */
  public static String getProcessScopeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ProcessScope)) {
      AbstractProcess _process = null;
      if (((ProcessScope)object)!=null) {
        _process=((ProcessScope)object).getProcess();
      }
      final AbstractProcess proc = _process;
      String _xifexpression = null;
      String _name = null;
      if (proc!=null) {
        _name=proc.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<process>";
      } else {
        EClass _eClass = proc.eClass();
        String _name_1 = _eClass.getName();
        String _plus = (_name_1 + " ");
        String _name_2 = proc.getName();
        _xifexpression = (_plus + _name_2);
      }
      final String s1 = _xifexpression;
      return ("Scope: " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getProcessScopeItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ProcessScope.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_SCOPE__PROCESS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * RunnableScopeItemProvider
   */
  public static String getRunnableScopeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableScope)) {
      org.eclipse.app4mc.amalthea.model.Runnable _runnable = null;
      if (((RunnableScope)object)!=null) {
        _runnable=((RunnableScope)object).getRunnable();
      }
      String _name = null;
      if (_runnable!=null) {
        _name=_runnable.getName();
      }
      final String runName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(runName);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = ("Runnable " + runName);
      }
      final String s1 = _xifexpression;
      return ("Scope: " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableScopeItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableScope.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_SCOPE__RUNNABLE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ArchitectureRequirementItemProvider
   */
  public static String getArchitectureRequirementItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ArchitectureRequirement)) {
      String _name = null;
      if (((ArchitectureRequirement)object)!=null) {
        _name=((ArchitectureRequirement)object).getName();
      }
      final String reqName = _name;
      Component _component = null;
      if (((ArchitectureRequirement)object)!=null) {
        _component=((ArchitectureRequirement)object).getComponent();
      }
      String _name_1 = null;
      if (_component!=null) {
        _name_1=_component.getName();
      }
      final String compName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(reqName);
      if (_isNullOrEmpty) {
        _xifexpression = "???";
      } else {
        _xifexpression = reqName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(compName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<component>";
      } else {
        _xifexpression_1 = ("Component " + compName);
      }
      final String s2 = _xifexpression_1;
      return ((("Req " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getArchitectureRequirementItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ArchitectureRequirement.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ARCHITECTURE_REQUIREMENT__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ARCHITECTURE_REQUIREMENT__COMPONENT)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * CountRequirementLimitItemProvider
   */
  public static String getCountRequirementLimitItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof CountRequirementLimit)) {
      CountMetric _metric = null;
      if (((CountRequirementLimit)object)!=null) {
        _metric=((CountRequirementLimit)object).getMetric();
      }
      final CountMetric metric = _metric;
      LimitType _limitType = null;
      if (((CountRequirementLimit)object)!=null) {
        _limitType=((CountRequirementLimit)object).getLimitType();
      }
      final LimitType limitType = _limitType;
      int _xifexpression = (int) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((CountRequirementLimit)object).getLimitValue();
      }
      final int limitValue = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(metric, null) || Objects.equal(metric, CountMetric._UNDEFINED_))) {
        _xifexpression_1 = "<count metric>";
      } else {
        String _literal = metric.getLiteral();
        _xifexpression_1 = (_literal + " count");
      }
      final String s1 = _xifexpression_1;
      final String s2 = CustomItemProviderService.getLimitTypeText(limitType);
      final String s3 = Double.toString(limitValue);
      return ((s1 + s2) + s3);
    } else {
      return defaultText;
    }
  }
  
  /**
   * CPUPercentageRequirementLimitItemProvider
   */
  public static String getCPUPercentageRequirementLimitItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof CPUPercentageRequirementLimit)) {
      CPUPercentageMetric _metric = null;
      if (((CPUPercentageRequirementLimit)object)!=null) {
        _metric=((CPUPercentageRequirementLimit)object).getMetric();
      }
      final CPUPercentageMetric metric = _metric;
      ComplexNode _hardwareContext = null;
      if (((CPUPercentageRequirementLimit)object)!=null) {
        _hardwareContext=((CPUPercentageRequirementLimit)object).getHardwareContext();
      }
      String _name = null;
      if (_hardwareContext!=null) {
        _name=_hardwareContext.getName();
      }
      final String hwContext = _name;
      LimitType _limitType = null;
      if (((CPUPercentageRequirementLimit)object)!=null) {
        _limitType=((CPUPercentageRequirementLimit)object).getLimitType();
      }
      final LimitType limitType = _limitType;
      double _xifexpression = (double) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((CPUPercentageRequirementLimit)object).getLimitValue();
      }
      final double limitValue = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(metric, null) || Objects.equal(metric, CPUPercentageMetric._UNDEFINED_))) {
        _xifexpression_1 = "<CPU % metric>";
      } else {
        _xifexpression_1 = metric.getLiteral();
      }
      final String s1 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(hwContext);
      if (_isNullOrEmpty) {
        _xifexpression_2 = "";
      } else {
        _xifexpression_2 = (" on " + hwContext);
      }
      final String s2 = _xifexpression_2;
      final String s3 = CustomItemProviderService.getLimitTypeText(limitType);
      String _string = Double.toString(limitValue);
      final String s4 = (_string + " %");
      return (((s1 + s2) + s3) + s4);
    } else {
      return defaultText;
    }
  }
  
  /**
   * FrequencyRequirementLimitItemProvider
   */
  public static String getFrequencyRequirementLimitItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof FrequencyRequirementLimit)) {
      FrequencyMetric _metric = null;
      if (((FrequencyRequirementLimit)object)!=null) {
        _metric=((FrequencyRequirementLimit)object).getMetric();
      }
      final FrequencyMetric metric = _metric;
      LimitType _limitType = null;
      if (((FrequencyRequirementLimit)object)!=null) {
        _limitType=((FrequencyRequirementLimit)object).getLimitType();
      }
      final LimitType limitType = _limitType;
      Frequency _limitValue = null;
      if (((FrequencyRequirementLimit)object)!=null) {
        _limitValue=((FrequencyRequirementLimit)object).getLimitValue();
      }
      final Frequency limitValue = _limitValue;
      String _xifexpression = null;
      if ((Objects.equal(metric, null) || Objects.equal(metric, FrequencyMetric._UNDEFINED_))) {
        _xifexpression = "<frequency metric>";
      } else {
        _xifexpression = metric.getLiteral();
      }
      final String s1 = _xifexpression;
      final String s2 = CustomItemProviderService.getLimitTypeText(limitType);
      final String s3 = CustomItemProviderService.getFrequencyText(limitValue);
      return ((s1 + s2) + s3);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getFrequencyRequirementLimitItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(FrequencyRequirementLimit.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.FREQUENCY_REQUIREMENT_LIMIT__METRIC)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.FREQUENCY_REQUIREMENT_LIMIT__LIMIT_VALUE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * PercentageRequirementLimitItemProvider
   */
  public static String getPercentageRequirementLimitItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof PercentageRequirementLimit)) {
      PercentageMetric _metric = null;
      if (((PercentageRequirementLimit)object)!=null) {
        _metric=((PercentageRequirementLimit)object).getMetric();
      }
      final PercentageMetric metric = _metric;
      LimitType _limitType = null;
      if (((PercentageRequirementLimit)object)!=null) {
        _limitType=((PercentageRequirementLimit)object).getLimitType();
      }
      final LimitType limitType = _limitType;
      double _xifexpression = (double) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((PercentageRequirementLimit)object).getLimitValue();
      }
      final double limitValue = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(metric, null) || Objects.equal(metric, PercentageMetric._UNDEFINED_))) {
        _xifexpression_1 = "<% metric>";
      } else {
        _xifexpression_1 = metric.getLiteral();
      }
      final String s1 = _xifexpression_1;
      final String s2 = CustomItemProviderService.getLimitTypeText(limitType);
      String _string = Double.toString(limitValue);
      final String s3 = (_string + " %");
      return ((s1 + s2) + s3);
    } else {
      return defaultText;
    }
  }
  
  /**
   * TimeRequirementLimitItemProvider
   */
  public static String getTimeRequirementLimitItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TimeRequirementLimit)) {
      TimeMetric _metric = null;
      if (((TimeRequirementLimit)object)!=null) {
        _metric=((TimeRequirementLimit)object).getMetric();
      }
      final TimeMetric metric = _metric;
      LimitType _limitType = null;
      if (((TimeRequirementLimit)object)!=null) {
        _limitType=((TimeRequirementLimit)object).getLimitType();
      }
      final LimitType limitType = _limitType;
      SignedTime _limitValue = null;
      if (((TimeRequirementLimit)object)!=null) {
        _limitValue=((TimeRequirementLimit)object).getLimitValue();
      }
      final SignedTime limitValue = _limitValue;
      String _xifexpression = null;
      if ((Objects.equal(metric, null) || Objects.equal(metric, TimeMetric._UNDEFINED_))) {
        _xifexpression = "<time metric>";
      } else {
        _xifexpression = metric.getLiteral();
      }
      final String s1 = _xifexpression;
      final String s2 = CustomItemProviderService.getLimitTypeText(limitType);
      final String s3 = CustomItemProviderService.getTimeText(limitValue);
      return ((s1 + s2) + s3);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTimeRequirementLimitItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TimeRequirementLimit.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TIME_REQUIREMENT_LIMIT__METRIC)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.TIME_REQUIREMENT_LIMIT__LIMIT_VALUE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ProcessRequirementItemProvider
   */
  public static String getProcessRequirementItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ProcessRequirement)) {
      String _name = null;
      if (((ProcessRequirement)object)!=null) {
        _name=((ProcessRequirement)object).getName();
      }
      final String reqName = _name;
      AbstractProcess _process = null;
      if (((ProcessRequirement)object)!=null) {
        _process=((ProcessRequirement)object).getProcess();
      }
      final AbstractProcess proc = _process;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(reqName);
      if (_isNullOrEmpty) {
        _xifexpression = "???";
      } else {
        _xifexpression = reqName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      String _name_1 = null;
      if (proc!=null) {
        _name_1=proc.getName();
      }
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<process>";
      } else {
        EClass _eClass = proc.eClass();
        String _name_2 = _eClass.getName();
        String _plus = (_name_2 + " ");
        String _name_3 = proc.getName();
        _xifexpression_1 = (_plus + _name_3);
      }
      final String s2 = _xifexpression_1;
      return ((("Req " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getProcessRequirementItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ProcessRequirement.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_REQUIREMENT__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_REQUIREMENT__PROCESS)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * RunnableRequirementItemProvider
   */
  public static String getRunnableRequirementItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableRequirement)) {
      String _name = null;
      if (((RunnableRequirement)object)!=null) {
        _name=((RunnableRequirement)object).getName();
      }
      final String reqName = _name;
      org.eclipse.app4mc.amalthea.model.Runnable _runnable = null;
      if (((RunnableRequirement)object)!=null) {
        _runnable=((RunnableRequirement)object).getRunnable();
      }
      String _name_1 = null;
      if (_runnable!=null) {
        _name_1=_runnable.getName();
      }
      final String runName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(reqName);
      if (_isNullOrEmpty) {
        _xifexpression = "???";
      } else {
        _xifexpression = reqName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(runName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<runnable>";
      } else {
        _xifexpression_1 = ("Runnable " + runName);
      }
      final String s2 = _xifexpression_1;
      return ((("Req " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableRequirementItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableRequirement.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_REQUIREMENT__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_REQUIREMENT__RUNNABLE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ProcessChainRequirementItemProvider
   */
  public static String getProcessChainRequirementItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ProcessChainRequirement)) {
      String _name = null;
      if (((ProcessChainRequirement)object)!=null) {
        _name=((ProcessChainRequirement)object).getName();
      }
      final String reqName = _name;
      ProcessChain _processChain = null;
      if (((ProcessChainRequirement)object)!=null) {
        _processChain=((ProcessChainRequirement)object).getProcessChain();
      }
      String _name_1 = null;
      if (_processChain!=null) {
        _name_1=_processChain.getName();
      }
      final String pcName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(reqName);
      if (_isNullOrEmpty) {
        _xifexpression = "???";
      } else {
        _xifexpression = reqName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(pcName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<process chain>";
      } else {
        _xifexpression_1 = ("Process Chain " + pcName);
      }
      final String s2 = _xifexpression_1;
      return ((("Req " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getProcessChainRequirementItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ProcessChainRequirement.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_CHAIN_REQUIREMENT__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_CHAIN_REQUIREMENT__PROCESS_CHAIN)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * DataAgeCycleItemProvider
   */
  public static String getDataAgeCycleItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataAgeCycle)) {
      int _minimumCycle = ((DataAgeCycle)object).getMinimumCycle();
      String _plus = ("Age cycles c: " + Integer.valueOf(_minimumCycle));
      String _plus_1 = (_plus + " <= c <= ");
      int _maximumCycle = ((DataAgeCycle)object).getMaximumCycle();
      return (_plus_1 + Integer.valueOf(_maximumCycle));
    } else {
      return defaultText;
    }
  }
  
  /**
   * DataAgeTimeItemProvider
   */
  public static String getDataAgeTimeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataAgeTime)) {
      Time _minimumTime = null;
      if (((DataAgeTime)object)!=null) {
        _minimumTime=((DataAgeTime)object).getMinimumTime();
      }
      final Time minTime = _minimumTime;
      Time _maximumTime = null;
      if (((DataAgeTime)object)!=null) {
        _maximumTime=((DataAgeTime)object).getMaximumTime();
      }
      final Time maxTime = _maximumTime;
      String _timeText = CustomItemProviderService.getTimeText(minTime);
      String _plus = ("Age time t: " + _timeText);
      String _plus_1 = (_plus + " <= t <= ");
      String _timeText_1 = CustomItemProviderService.getTimeText(maxTime);
      return (_plus_1 + _timeText_1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getDataAgeTimeItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(DataAgeTime.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.DATA_AGE_TIME__MINIMUM_TIME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DATA_AGE_TIME__MAXIMUM_TIME)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, true, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * DataCoherencyGroupItemProvider
   */
  public static String getDataCoherencyGroupItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataCoherencyGroup)) {
      String _name = null;
      if (((DataCoherencyGroup)object)!=null) {
        _name=((DataCoherencyGroup)object).getName();
      }
      final String name = _name;
      CoherencyDirection _direction = null;
      if (((DataCoherencyGroup)object)!=null) {
        _direction=((DataCoherencyGroup)object).getDirection();
      }
      final CoherencyDirection direction = _direction;
      DataGroupScope _scope = null;
      if (((DataCoherencyGroup)object)!=null) {
        _scope=((DataCoherencyGroup)object).getScope();
      }
      final DataGroupScope scope = _scope;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<group>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(direction, null) || Objects.equal(direction, CoherencyDirection._UNDEFINED_))) {
        _xifexpression_1 = "<direction>";
      } else {
        _xifexpression_1 = direction.getLiteral();
      }
      final String s2 = _xifexpression_1;
      String _switchResult = null;
      boolean _matched = false;
      if (scope instanceof RunnableScope) {
        _matched=true;
        String _xifexpression_2 = null;
        org.eclipse.app4mc.amalthea.model.Runnable _runnable = ((RunnableScope)scope).getRunnable();
        String _name_1 = null;
        if (_runnable!=null) {
          _name_1=_runnable.getName();
        }
        boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
        if (_isNullOrEmpty_1) {
          _xifexpression_2 = "<runnable>";
        } else {
          org.eclipse.app4mc.amalthea.model.Runnable _runnable_1 = ((RunnableScope)scope).getRunnable();
          String _name_2 = _runnable_1.getName();
          _xifexpression_2 = ("Runnable " + _name_2);
        }
        _switchResult = _xifexpression_2;
      }
      if (!_matched) {
        if (scope instanceof ProcessScope) {
          _matched=true;
          String _xifexpression_2 = null;
          AbstractProcess _process = ((ProcessScope)scope).getProcess();
          String _name_1 = null;
          if (_process!=null) {
            _name_1=_process.getName();
          }
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
          if (_isNullOrEmpty_1) {
            _xifexpression_2 = "<process>";
          } else {
            AbstractProcess _process_1 = ((ProcessScope)scope).getProcess();
            EClass _eClass = _process_1.eClass();
            String _name_2 = _eClass.getName();
            String _plus = (_name_2 + " ");
            AbstractProcess _process_2 = ((ProcessScope)scope).getProcess();
            String _name_3 = _process_2.getName();
            _xifexpression_2 = (_plus + _name_3);
          }
          _switchResult = _xifexpression_2;
        }
      }
      if (!_matched) {
        if (scope instanceof ComponentScope) {
          _matched=true;
          String _xifexpression_2 = null;
          Component _component = ((ComponentScope)scope).getComponent();
          String _name_1 = null;
          if (_component!=null) {
            _name_1=_component.getName();
          }
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
          if (_isNullOrEmpty_1) {
            _xifexpression_2 = "<component>";
          } else {
            Component _component_1 = ((ComponentScope)scope).getComponent();
            String _name_2 = _component_1.getName();
            _xifexpression_2 = ("Component " + _name_2);
          }
          _switchResult = _xifexpression_2;
        }
      }
      if (!_matched) {
        _switchResult = "?";
      }
      final String s3 = _switchResult;
      return (((((("CoherencyGroup " + s1) + " ") + s2) + " (Scope: ") + s3) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getDataCoherencyGroupItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(DataCoherencyGroup.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.DATA_COHERENCY_GROUP__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DATA_COHERENCY_GROUP__DIRECTION)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.DATA_COHERENCY_GROUP__SCOPE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * EventChainReferenceItemProvider
   */
  public static String getEventChainReferenceItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof EventChainReference)) {
      EventChain _eventChain = null;
      if (((EventChainReference)object)!=null) {
        _eventChain=((EventChainReference)object).getEventChain();
      }
      String _name = null;
      if (_eventChain!=null) {
        _name=_eventChain.getName();
      }
      final String chainName = _name;
      final String s1 = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(chainName);
      if (_isNullOrEmpty) {
        _xifexpression = "<chain>";
      } else {
        _xifexpression = chainName;
      }
      final String s2 = _xifexpression;
      return (("Chain Ref " + s1) + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getEventChainReferenceItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(EventChainReference.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.EVENT_CHAIN_REFERENCE__EVENT_CHAIN)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * SubEventChainItemProvider
   */
  public static String getSubEventChainItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SubEventChain)) {
      EventChain _eventChain = null;
      if (((SubEventChain)object)!=null) {
        _eventChain=((SubEventChain)object).getEventChain();
      }
      String _name = null;
      if (_eventChain!=null) {
        _name=_eventChain.getName();
      }
      final String chainName = _name;
      final String s1 = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(chainName);
      if (_isNullOrEmpty) {
        _xifexpression = "<sub chain>";
      } else {
        _xifexpression = ("Sub Chain " + chainName);
      }
      final String s2 = _xifexpression;
      return (s1 + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSubEventChainItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SubEventChain.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SUB_EVENT_CHAIN__EVENT_CHAIN)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, true, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * TagGroupItemProvider
   */
  public static String getTagGroupItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TagGroup)) {
      Tag _tag = null;
      if (((TagGroup)object)!=null) {
        _tag=((TagGroup)object).getTag();
      }
      String _name = null;
      if (_tag!=null) {
        _name=_tag.getName();
      }
      final String tagName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(tagName);
      if (_isNullOrEmpty) {
        _xifexpression = "<tag>";
      } else {
        _xifexpression = (("\"" + tagName) + "\"");
      }
      final String s1 = _xifexpression;
      return ("Items with tag " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTagGroupItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TagGroup.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TAG_GROUP__TAG)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * PhysicalSectionConstraintItemProvider
   */
  public static String getPhysicalSectionConstraintItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof PhysicalSectionConstraint)) {
      Section _section = null;
      if (((PhysicalSectionConstraint)object)!=null) {
        _section=((PhysicalSectionConstraint)object).getSection();
      }
      final Section section = _section;
      EList<Memory> _memories = null;
      if (((PhysicalSectionConstraint)object)!=null) {
        _memories=((PhysicalSectionConstraint)object).getMemories();
      }
      final EList<Memory> memories = _memories;
      String _xifexpression = null;
      String _name = null;
      if (section!=null) {
        _name=section.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<section>";
      } else {
        String _name_1 = section.getName();
        _xifexpression = ("Section :  " + _name_1);
      }
      final String sectionString = _xifexpression;
      final List<String> memoryNames = new ArrayList<String>();
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(memories);
      boolean _not = (!_isNullOrEmpty_1);
      if (_not) {
        final Consumer<Memory> _function = (Memory it) -> {
          String _xifexpression_1 = null;
          String _name_2 = null;
          if (it!=null) {
            _name_2=it.getName();
          }
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_name_2);
          if (_isNullOrEmpty_2) {
            _xifexpression_1 = "???";
          } else {
            _xifexpression_1 = it.getName();
          }
          final String st = _xifexpression_1;
          memoryNames.add(st);
        };
        memories.forEach(_function);
      }
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_2 = IterableExtensions.isNullOrEmpty(memoryNames);
      if (_isNullOrEmpty_2) {
        _xifexpression_1 = "<memories>";
      } else {
        String _xifexpression_2 = null;
        int _size = memoryNames.size();
        boolean _greaterThan = (_size > 10);
        if (_greaterThan) {
          List<String> _subList = memoryNames.subList(0, 10);
          String _join = IterableExtensions.join(_subList, ", ");
          String _plus = (" Memories : " + _join);
          _xifexpression_2 = (_plus + ", ...");
        } else {
          String _join_1 = IterableExtensions.join(memoryNames, ", ");
          _xifexpression_2 = (" Memories : " + _join_1);
        }
        _xifexpression_1 = _xifexpression_2;
      }
      final String memoriesString = _xifexpression_1;
      String _xifexpression_3 = null;
      String _name_2 = null;
      if (((PhysicalSectionConstraint)object)!=null) {
        _name_2=((PhysicalSectionConstraint)object).getName();
      }
      boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_name_2);
      if (_isNullOrEmpty_3) {
        _xifexpression_3 = "<name>";
      } else {
        _xifexpression_3 = ((PhysicalSectionConstraint)object).getName();
      }
      final String s0 = _xifexpression_3;
      return ((((((s0 + " : (") + sectionString) + ")") + " --> (") + memoriesString) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getPhysicalSectionConstraintItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(PhysicalSectionConstraint.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_CONSTRAINT__NAME)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, false);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_CONSTRAINT__SECTION)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_CONSTRAINT__MEMORIES)) {
        _matched=true;
        Object _notifier_2 = notification.getNotifier();
        ViewerNotification _viewerNotification_2 = new ViewerNotification(notification, _notifier_2, true, true);
        list.add(_viewerNotification_2);
      }
    }
    return list;
  }
  
  /**
   * HwAccessPathItemProvider
   */
  public static String getHwAccessPathItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof HwAccessPath)) {
      String _name = null;
      if (((HwAccessPath)object)!=null) {
        _name=((HwAccessPath)object).getName();
      }
      final String name = _name;
      ComplexNode _source = null;
      if (((HwAccessPath)object)!=null) {
        _source=((HwAccessPath)object).getSource();
      }
      String _name_1 = null;
      if (_source!=null) {
        _name_1=_source.getName();
      }
      final String sourceName = _name_1;
      ComplexNode _target = null;
      if (((HwAccessPath)object)!=null) {
        _target=((HwAccessPath)object).getTarget();
      }
      String _name_2 = null;
      if (_target!=null) {
        _name_2=_target.getName();
      }
      final String targetName = _name_2;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<path>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(sourceName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<source>";
      } else {
        _xifexpression_1 = sourceName;
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(targetName);
      if (_isNullOrEmpty_2) {
        _xifexpression_2 = "<target>";
      } else {
        _xifexpression_2 = targetName;
      }
      final String s3 = _xifexpression_2;
      return ((((("AccessPath (Hardware) " + s1) + " : ") + s2) + " --> ") + s3);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getHwAccessPathItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(HwAccessPath.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.HW_ACCESS_PATH__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.HW_ACCESS_PATH__SOURCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.HW_ACCESS_PATH__TARGET)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.HW_ACCESS_PATH__HW_ELEMENTS)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * AccessPathRefItemProvider
   */
  public static String getAccessPathRefItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof AccessPathRef)) {
      LatencyAccessPath _ref = null;
      if (((AccessPathRef)object)!=null) {
        _ref=((AccessPathRef)object).getRef();
      }
      String _name = null;
      if (_ref!=null) {
        _name=_ref.getName();
      }
      final String refName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(refName);
      if (_isNullOrEmpty) {
        _xifexpression = "<path ref>";
      } else {
        _xifexpression = ("Path " + refName);
      }
      final String s1 = _xifexpression;
      return ("Ref -> " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * HwAccessPathRefItemProvider
   */
  public static String getHwAccessPathRefItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof HwAccessPathRef)) {
      HwAccessPath _ref = null;
      if (((HwAccessPathRef)object)!=null) {
        _ref=((HwAccessPathRef)object).getRef();
      }
      final HwAccessPath ref = _ref;
      String _xifexpression = null;
      boolean _equals = Objects.equal(ref, null);
      if (_equals) {
        _xifexpression = "<path ref>";
      } else {
        String _name = ref.getName();
        _xifexpression = ("Path " + _name);
      }
      final String s1 = _xifexpression;
      return ("Ref -> " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getHwAccessPathRefItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(HwAccessPathRef.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.HW_ACCESS_PATH_REF__REF)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * HwElementRefItemProvider
   */
  public static String getHwElementRefItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof HwElementRef)) {
      ComplexPort _port = null;
      if (((HwElementRef)object)!=null) {
        _port=((HwElementRef)object).getPort();
      }
      String _name = null;
      if (_port!=null) {
        _name=_port.getName();
      }
      final String portName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(portName);
      if (_isNullOrEmpty) {
        _xifexpression = "<port>";
      } else {
        _xifexpression = ("Port " + portName);
      }
      final String s1 = _xifexpression;
      return ("Ref -> " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getHwElementRefItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(HwElementRef.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.HW_ELEMENT_REF__PORT)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * LatencyAccessPathItemProvider
   */
  public static String getLatencyAccessPathItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof LatencyAccessPath)) {
      String _name = null;
      if (((LatencyAccessPath)object)!=null) {
        _name=((LatencyAccessPath)object).getName();
      }
      final String name = _name;
      ComplexNode _source = null;
      if (((LatencyAccessPath)object)!=null) {
        _source=((LatencyAccessPath)object).getSource();
      }
      String _name_1 = null;
      if (_source!=null) {
        _name_1=_source.getName();
      }
      final String sourceName = _name_1;
      ComplexNode _target = null;
      if (((LatencyAccessPath)object)!=null) {
        _target=((LatencyAccessPath)object).getTarget();
      }
      String _name_2 = null;
      if (_target!=null) {
        _name_2=_target.getName();
      }
      final String targetName = _name_2;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<path>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(sourceName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<source>";
      } else {
        _xifexpression_1 = sourceName;
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(targetName);
      if (_isNullOrEmpty_2) {
        _xifexpression_2 = "<target>";
      } else {
        _xifexpression_2 = targetName;
      }
      final String s3 = _xifexpression_2;
      return ((((("AccessPath (Latency) " + s1) + " : ") + s2) + " --> ") + s3);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getLatencyAccessPathItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(LatencyAccessPath.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_ACCESS_PATH__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_ACCESS_PATH__SOURCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_ACCESS_PATH__TARGET)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_ACCESS_PATH__LATENCIES)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * LatencyConstantItemProvider
   */
  public static String getLatencyConstantItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof LatencyConstant)) {
      RWType _accessType = null;
      if (((LatencyConstant)object)!=null) {
        _accessType=((LatencyConstant)object).getAccessType();
      }
      final RWType type = _accessType;
      long _xifexpression = (long) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((LatencyConstant)object).getValue();
      }
      final long value = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(type, null) || Objects.equal(type, RWType._UNDEFINED_))) {
        _xifexpression_1 = "?";
      } else {
        _xifexpression_1 = type.getLiteral();
      }
      final String s1 = _xifexpression_1;
      final String s2 = Long.toString(value);
      return ((("Access: " + s1) + " -- Latency (constant): ") + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * LatencyDeviationItemProvider
   */
  public static String getLatencyDeviationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof LatencyDeviation)) {
      final RWType type = ((LatencyDeviation)object).getAccessType();
      Deviation<LongObject> _deviation = null;
      if (((LatencyDeviation)object)!=null) {
        _deviation=((LatencyDeviation)object).getDeviation();
      }
      Distribution<LongObject> _distribution = null;
      if (_deviation!=null) {
        _distribution=_deviation.getDistribution();
      }
      EClass _eClass = null;
      if (_distribution!=null) {
        _eClass=_distribution.eClass();
      }
      String _name = null;
      if (_eClass!=null) {
        _name=_eClass.getName();
      }
      final String distName = _name;
      String _xifexpression = null;
      if ((Objects.equal(type, null) || Objects.equal(type, RWType._UNDEFINED_))) {
        _xifexpression = "?";
      } else {
        _xifexpression = type.getLiteral();
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(distName);
      if (_isNullOrEmpty) {
        _xifexpression_1 = "<distribution>";
      } else {
        _xifexpression_1 = CustomItemProviderService.trimDistName(distName);
      }
      final String s2 = _xifexpression_1;
      return ((("Access: " + s1) + " -- Latency (deviation): ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getLatencyDeviationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(LatencyDeviation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_DEVIATION__ACCESS_TYPE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LATENCY_DEVIATION__DEVIATION)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * MappingModelItemProvider
   */
  public static String getMappingModelItemProviderText(final Object object, final String defaultText) {
    return "Mapping";
  }
  
  /**
   * CoreAllocationItemProvider
   */
  public static String getCoreAllocationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof CoreAllocation)) {
      Scheduler _scheduler = null;
      if (((CoreAllocation)object)!=null) {
        _scheduler=((CoreAllocation)object).getScheduler();
      }
      String _name = null;
      if (_scheduler!=null) {
        _name=_scheduler.getName();
      }
      final String schedName = _name;
      EList<Core> _core = null;
      if (((CoreAllocation)object)!=null) {
        _core=((CoreAllocation)object).getCore();
      }
      final EList<Core> cores = _core;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(schedName);
      if (_isNullOrEmpty) {
        _xifexpression = "<scheduler>";
      } else {
        _xifexpression = ("Scheduler " + schedName);
      }
      final String s1 = _xifexpression;
      final Function1<Core, String> _function = (Core it) -> {
        String _xifexpression_1 = null;
        String _name_1 = it.getName();
        boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
        if (_isNullOrEmpty_1) {
          _xifexpression_1 = "???";
        } else {
          _xifexpression_1 = it.getName();
        }
        return _xifexpression_1;
      };
      List<String> _map = ListExtensions.<Core, String>map(cores, _function);
      final String s2 = IterableExtensions.join(_map, ", ");
      return (((("Allocation: " + s1) + " -- Cores ( ") + s2) + " )");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getCoreAllocationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(CoreAllocation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.CORE_ALLOCATION__SCHEDULER)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CORE_ALLOCATION__CORE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CORE_ALLOCATION__CUSTOM_PROPERTIES)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ISRAllocationItemProvider
   */
  public static String getISRAllocationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ISRAllocation)) {
      InterruptController _controller = null;
      if (((ISRAllocation)object)!=null) {
        _controller=((ISRAllocation)object).getController();
      }
      String _name = null;
      if (_controller!=null) {
        _name=_controller.getName();
      }
      final String ctrlName = _name;
      ISR _isr = null;
      if (((ISRAllocation)object)!=null) {
        _isr=((ISRAllocation)object).getIsr();
      }
      String _name_1 = null;
      if (_isr!=null) {
        _name_1=_isr.getName();
      }
      final String isrName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(ctrlName);
      if (_isNullOrEmpty) {
        _xifexpression = "<controller>";
      } else {
        _xifexpression = ("Controller " + ctrlName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(isrName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<isr>";
      } else {
        _xifexpression_1 = ("ISR " + isrName);
      }
      final String s2 = _xifexpression_1;
      return ((("Allocation: " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getISRAllocationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ISRAllocation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ISR_ALLOCATION__CONTROLLER)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ISR_ALLOCATION__ISR)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * RunnableAllocationItemProvider
   */
  public static String getRunnableAllocationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableAllocation)) {
      Scheduler _scheduler = null;
      if (((RunnableAllocation)object)!=null) {
        _scheduler=((RunnableAllocation)object).getScheduler();
      }
      String _name = null;
      if (_scheduler!=null) {
        _name=_scheduler.getName();
      }
      final String schedName = _name;
      org.eclipse.app4mc.amalthea.model.Runnable _entity = null;
      if (((RunnableAllocation)object)!=null) {
        _entity=((RunnableAllocation)object).getEntity();
      }
      String _name_1 = null;
      if (_entity!=null) {
        _name_1=_entity.getName();
      }
      final String entityName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(schedName);
      if (_isNullOrEmpty) {
        _xifexpression = "<scheduler>";
      } else {
        _xifexpression = ("Scheduler " + schedName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(entityName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<runnable>";
      } else {
        _xifexpression_1 = ("Runnable " + entityName);
      }
      final String s2 = _xifexpression_1;
      return ((("Allocation: " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableAllocationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableAllocation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_ALLOCATION__ENTITY)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_ALLOCATION__SCHEDULER)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * TaskAllocationItemProvider
   */
  public static String getTaskAllocationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TaskAllocation)) {
      TaskScheduler _scheduler = null;
      if (((TaskAllocation)object)!=null) {
        _scheduler=((TaskAllocation)object).getScheduler();
      }
      String _name = null;
      if (_scheduler!=null) {
        _name=_scheduler.getName();
      }
      final String schedName = _name;
      Task _task = null;
      if (((TaskAllocation)object)!=null) {
        _task=((TaskAllocation)object).getTask();
      }
      String _name_1 = null;
      if (_task!=null) {
        _name_1=_task.getName();
      }
      final String taskName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(schedName);
      if (_isNullOrEmpty) {
        _xifexpression = "<scheduler>";
      } else {
        _xifexpression = ("Scheduler " + schedName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(taskName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<task>";
      } else {
        _xifexpression_1 = ("Task " + taskName);
      }
      final String s2 = _xifexpression_1;
      return ((("Allocation: " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTaskAllocationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TaskAllocation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TASK_ALLOCATION__TASK)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.TASK_ALLOCATION__SCHEDULER)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * AbstractElementMappingItemProvider
   */
  public static String getAbstractElementMappingItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof AbstractElementMapping)) {
      Memory _memory = null;
      if (((AbstractElementMapping)object)!=null) {
        _memory=((AbstractElementMapping)object).getMemory();
      }
      String _name = null;
      if (_memory!=null) {
        _name=_memory.getName();
      }
      final String memName = _name;
      AbstractElementMemoryInformation _abstractElement = null;
      if (((AbstractElementMapping)object)!=null) {
        _abstractElement=((AbstractElementMapping)object).getAbstractElement();
      }
      final AbstractElementMemoryInformation elem = _abstractElement;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(memName);
      if (_isNullOrEmpty) {
        _xifexpression = "<memory>";
      } else {
        _xifexpression = ("Memory " + memName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      String _name_1 = null;
      if (elem!=null) {
        _name_1=elem.getName();
      }
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_name_1);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<element>";
      } else {
        EClass _eClass = elem.eClass();
        String _name_2 = _eClass.getName();
        String _plus = (_name_2 + " ");
        String _name_3 = elem.getName();
        _xifexpression_1 = (_plus + _name_3);
      }
      final String s2 = _xifexpression_1;
      return ((("Mapping: " + s1) + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getAbstractElementMappingItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(AbstractElementMapping.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ABSTRACT_ELEMENT_MAPPING__MEMORY)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ABSTRACT_ELEMENT_MAPPING__ABSTRACT_ELEMENT)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * PhysicalSectionMappingItemProvider
   */
  public static String getPhysicalSectionMappingItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof PhysicalSectionMapping)) {
      Memory _memory = null;
      if (((PhysicalSectionMapping)object)!=null) {
        _memory=((PhysicalSectionMapping)object).getMemory();
      }
      final Memory memory = _memory;
      EList<Section> _origin = null;
      if (((PhysicalSectionMapping)object)!=null) {
        _origin=((PhysicalSectionMapping)object).getOrigin();
      }
      final EList<Section> sections = _origin;
      String _xifexpression = null;
      String _name = null;
      if (memory!=null) {
        _name=memory.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<memory>";
      } else {
        String _name_1 = memory.getName();
        _xifexpression = ("Memory :  " + _name_1);
      }
      final String memoryString = _xifexpression;
      final List<String> sectionNames = new ArrayList<String>();
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(sections);
      boolean _not = (!_isNullOrEmpty_1);
      if (_not) {
        final Consumer<Section> _function = (Section it) -> {
          String _xifexpression_1 = null;
          String _name_2 = null;
          if (it!=null) {
            _name_2=it.getName();
          }
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_name_2);
          if (_isNullOrEmpty_2) {
            _xifexpression_1 = "???";
          } else {
            _xifexpression_1 = it.getName();
          }
          final String st = _xifexpression_1;
          sectionNames.add(st);
        };
        sections.forEach(_function);
      }
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_2 = IterableExtensions.isNullOrEmpty(sectionNames);
      if (_isNullOrEmpty_2) {
        _xifexpression_1 = "<sections>";
      } else {
        String _xifexpression_2 = null;
        int _size = sectionNames.size();
        boolean _greaterThan = (_size > 10);
        if (_greaterThan) {
          List<String> _subList = sectionNames.subList(0, 10);
          String _join = IterableExtensions.join(_subList, ", ");
          String _plus = (" Sections : " + _join);
          _xifexpression_2 = (_plus + ", ...");
        } else {
          String _join_1 = IterableExtensions.join(sectionNames, ", ");
          _xifexpression_2 = (" Sections : " + _join_1);
        }
        _xifexpression_1 = _xifexpression_2;
      }
      final String sectionsString = _xifexpression_1;
      String _xifexpression_3 = null;
      String _name_2 = null;
      if (((PhysicalSectionMapping)object)!=null) {
        _name_2=((PhysicalSectionMapping)object).getName();
      }
      boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_name_2);
      if (_isNullOrEmpty_3) {
        _xifexpression_3 = "<name>";
      } else {
        _xifexpression_3 = ((PhysicalSectionMapping)object).getName();
      }
      final String s0 = _xifexpression_3;
      return ((((((s0 + " : (") + sectionsString) + ")") + " --> (") + memoryString) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getPhysicalSectionMappingItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(PhysicalSectionMapping.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_MAPPING__MEMORY)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_MAPPING__ORIGIN)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.PHYSICAL_SECTION_MAPPING__NAME)) {
        _matched=true;
        Object _notifier_2 = notification.getNotifier();
        ViewerNotification _viewerNotification_2 = new ViewerNotification(notification, _notifier_2, true, false);
        list.add(_viewerNotification_2);
      }
    }
    return list;
  }
  
  /**
   * OsDataConsistencyItemProvider
   */
  public static String getOsDataConsistencyItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof OsDataConsistency)) {
      final OsDataConsistencyMode mode = ((OsDataConsistency)object).getMode();
      final String s1 = "OS Data Consistency - ";
      String _xifexpression = null;
      if ((Objects.equal(mode, null) || Objects.equal(mode, OsDataConsistencyMode._UNDEFINED_))) {
        _xifexpression = "?";
      } else {
        _xifexpression = mode.getLiteral();
      }
      final String s2 = _xifexpression;
      return (s1 + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * DataStabilityItemProvider
   */
  public static String getDataStabilityItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataStability)) {
      boolean _isEnabled = ((DataStability)object).isEnabled();
      String _string = Boolean.valueOf(_isEnabled).toString();
      return ("OS Data Stability - enabled: " + _string);
    } else {
      return defaultText;
    }
  }
  
  /**
   * NonAtomicDataCoherencyItemProvider
   */
  public static String getNonAtomicDataCoherencyItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof NonAtomicDataCoherency)) {
      boolean _isEnabled = ((NonAtomicDataCoherency)object).isEnabled();
      String _string = Boolean.valueOf(_isEnabled).toString();
      return ("OS Data Coherency - enabled: " + _string);
    } else {
      return defaultText;
    }
  }
  
  /**
   * OsInstructionsItemProvider
   */
  public static String getOsInstructionsItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof OsInstructions)) {
      final String name = ((OsInstructions)object).getName();
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "OS Instructions";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * OsAPIInstructionsItemProvider
   */
  public static String getOsAPIInstructionsItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof OsAPIInstructions)) {
      return CustomItemProviderService.getContainingFeatureName(((EObject)object), "API Instructions", "");
    } else {
      return defaultText;
    }
  }
  
  /**
   * OsISRInstructionsItemProvider
   */
  public static String getOsISRInstructionsItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof OsISRInstructions)) {
      EStructuralFeature _eContainingFeature = null;
      if (((OsISRInstructions)object)!=null) {
        _eContainingFeature=((OsISRInstructions)object).eContainingFeature();
      }
      final EStructuralFeature feature = _eContainingFeature;
      String _xifexpression = null;
      boolean _equals = Objects.equal(feature, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = feature.getName();
      }
      final String s1 = _xifexpression;
      return s1;
    } else {
      return defaultText;
    }
  }
  
  /**
   * ProcessPrototypeAllocationConstraintItemProvider
   */
  public static String getProcessPrototypeAllocationConstraintItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ProcessPrototypeAllocationConstraint)) {
      ProcessPrototype _processPrototype = null;
      if (((ProcessPrototypeAllocationConstraint)object)!=null) {
        _processPrototype=((ProcessPrototypeAllocationConstraint)object).getProcessPrototype();
      }
      String _name = null;
      if (_processPrototype!=null) {
        _name=_processPrototype.getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<process prototype>";
      } else {
        _xifexpression = ("Prototype " + name);
      }
      final String s1 = _xifexpression;
      return ("Constraint allocation of " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getProcessPrototypeAllocationConstraintItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ProcessPrototypeAllocationConstraint.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_PROTOTYPE_ALLOCATION_CONSTRAINT__PROCESS_PROTOTYPE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ProcessAllocationConstraintItemProvider
   */
  public static String getProcessAllocationConstraintItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ProcessAllocationConstraint)) {
      org.eclipse.app4mc.amalthea.model.Process _process = null;
      if (((ProcessAllocationConstraint)object)!=null) {
        _process=((ProcessAllocationConstraint)object).getProcess();
      }
      final org.eclipse.app4mc.amalthea.model.Process proc = _process;
      String _xifexpression = null;
      String _name = null;
      if (proc!=null) {
        _name=proc.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<process>";
      } else {
        EClass _eClass = proc.eClass();
        String _name_1 = _eClass.getName();
        String _plus = (_name_1 + " ");
        String _name_2 = proc.getName();
        _xifexpression = (_plus + _name_2);
      }
      final String s1 = _xifexpression;
      return ("Constraint allocation of " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getProcessAllocationConstraintItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ProcessAllocationConstraint.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.PROCESS_ALLOCATION_CONSTRAINT__PROCESS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * RunnableAllocationConstraintItemProvider
   */
  public static String getRunnableAllocationConstraintItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableAllocationConstraint)) {
      org.eclipse.app4mc.amalthea.model.Runnable _runnable = null;
      if (((RunnableAllocationConstraint)object)!=null) {
        _runnable=((RunnableAllocationConstraint)object).getRunnable();
      }
      String _name = null;
      if (_runnable!=null) {
        _name=_runnable.getName();
      }
      final String runName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(runName);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = ("Runnable " + runName);
      }
      final String s1 = _xifexpression;
      return ("Constraint allocation of " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableAllocationConstraintItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableAllocationConstraint.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_ALLOCATION_CONSTRAINT__RUNNABLE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * AbstractElementMappingConstraintItemProvider
   */
  public static String getAbstractElementMappingConstraintItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof AbstractElementMappingConstraint)) {
      AbstractElementMemoryInformation _abstractElement = null;
      if (((AbstractElementMappingConstraint)object)!=null) {
        _abstractElement=((AbstractElementMappingConstraint)object).getAbstractElement();
      }
      final AbstractElementMemoryInformation elem = _abstractElement;
      String _xifexpression = null;
      String _name = null;
      if (elem!=null) {
        _name=elem.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<element>";
      } else {
        EClass _eClass = elem.eClass();
        String _name_1 = _eClass.getName();
        String _plus = (_name_1 + " ");
        String _name_2 = elem.getName();
        _xifexpression = (_plus + _name_2);
      }
      final String s1 = _xifexpression;
      return ("Constraint mapping of " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getAbstractElementMappingConstraintItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(AbstractElementMappingConstraint.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ABSTRACT_ELEMENT_MAPPING_CONSTRAINT__ABSTRACT_ELEMENT)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ModeValueListItemProvider
   */
  public static String getModeValueListItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeValueList)) {
      String _containingFeatureName = CustomItemProviderService.getContainingFeatureName(((EObject)object));
      return (_containingFeatureName + defaultText);
    } else {
      return defaultText;
    }
  }
  
  /**
   * ModeValueListEntryItemProvider
   */
  public static String getModeValueListEntryItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeValueListEntry)) {
      ModeValueProvider _valueProvider = null;
      if (((ModeValueListEntry)object)!=null) {
        _valueProvider=((ModeValueListEntry)object).getValueProvider();
      }
      final ModeValueProvider prov = _valueProvider;
      ModeLiteral _value = null;
      if (((ModeValueListEntry)object)!=null) {
        _value=((ModeValueListEntry)object).getValue();
      }
      final ModeLiteral value = _value;
      String _xifexpression = null;
      String _name = null;
      if (prov!=null) {
        _name=prov.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<mode label>";
      } else {
        String _name_1 = prov.getName();
        _xifexpression = ("Mode Label " + _name_1);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
        _xifexpression_1 = "<value>";
      } else {
        _xifexpression_1 = value.toString();
      }
      final String s2 = _xifexpression_1;
      return ((s1 + " == ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getModeValueListEntryItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ModeValueListEntry.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.MODE_VALUE_LIST_ENTRY__VALUE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.MODE_VALUE_LIST_ENTRY__VALUE_PROVIDER)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ArrivalCurveEntryItemProvider
   */
  public static String getArrivalCurveEntryItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ArrivalCurveEntry)) {
      int _xifexpression = (int) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((ArrivalCurveEntry)object).getNumberOfEvents();
      }
      final int numEvents = _xifexpression;
      Time _lowerTimeBorder = null;
      if (((ArrivalCurveEntry)object)!=null) {
        _lowerTimeBorder=((ArrivalCurveEntry)object).getLowerTimeBorder();
      }
      final String s1 = CustomItemProviderService.getTimeText(_lowerTimeBorder);
      Time _upperTimeBorder = null;
      if (((ArrivalCurveEntry)object)!=null) {
        _upperTimeBorder=((ArrivalCurveEntry)object).getUpperTimeBorder();
      }
      final String s2 = CustomItemProviderService.getTimeText(_upperTimeBorder);
      return ((((("#events: " + Integer.valueOf(numEvents)) + " -- interval: ") + s1) + ", ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getArrivalCurveEntryItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ArrivalCurveEntry.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ARRIVAL_CURVE_ENTRY__NUMBER_OF_EVENTS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ARRIVAL_CURVE_ENTRY__LOWER_TIME_BORDER)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(_featureID, AmaltheaPackage.ARRIVAL_CURVE_ENTRY__UPPER_TIME_BORDER)) {
          _matched=true;
        }
      }
      if (_matched) {
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  private static String getRunnableItemText(final RunnableItem item) {
    String _switchResult = null;
    boolean _matched = false;
    if (item instanceof LabelAccess) {
      _matched=true;
      _switchResult = CustomItemProviderService.getLabelAccessItemProviderText(item, null);
    }
    if (!_matched) {
      if (item instanceof RunnableCall) {
        _matched=true;
        _switchResult = CustomItemProviderService.getRunnableCallItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof RunnableInstructions) {
        _matched=true;
        _switchResult = "Runnable Instructions";
      }
    }
    if (!_matched) {
      if (item instanceof Group) {
        _matched=true;
        _switchResult = CustomItemProviderService.getGroupItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof RunnableModeSwitch) {
        _matched=true;
        _switchResult = CustomItemProviderService.getRunnableModeSwitchItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof RunnableProbabilitySwitch) {
        _matched=true;
        _switchResult = "Probability Switch";
      }
    }
    if (!_matched) {
      if (item instanceof ModeLabelAccess) {
        _matched=true;
        _switchResult = CustomItemProviderService.getModeLabelAccessItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof SemaphoreAccess) {
        _matched=true;
        _switchResult = CustomItemProviderService.getSemaphoreAccessItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof SenderReceiverRead) {
        _matched=true;
        _switchResult = CustomItemProviderService.getSenderReceiverReadItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof SenderReceiverWrite) {
        _matched=true;
        _switchResult = CustomItemProviderService.getSenderReceiverWriteItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof AsynchronousServerCall) {
        _matched=true;
        _switchResult = CustomItemProviderService.getAsynchronousServerCallItemProviderText(item, null);
      }
    }
    if (!_matched) {
      if (item instanceof SynchronousServerCall) {
        _matched=true;
        _switchResult = CustomItemProviderService.getSynchronousServerCallItemProviderText(item, null);
      }
    }
    return _switchResult;
  }
  
  /**
   * AccessPrecedenceSpecItemProvider
   */
  public static String getAccessPrecedenceSpecItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof AccessPrecedenceSpec)) {
      org.eclipse.app4mc.amalthea.model.Runnable _origin = null;
      if (((AccessPrecedenceSpec)object)!=null) {
        _origin=((AccessPrecedenceSpec)object).getOrigin();
      }
      String _name = null;
      if (_origin!=null) {
        _name=_origin.getName();
      }
      final String originName = _name;
      org.eclipse.app4mc.amalthea.model.Runnable _target = null;
      if (((AccessPrecedenceSpec)object)!=null) {
        _target=((AccessPrecedenceSpec)object).getTarget();
      }
      String _name_1 = null;
      if (_target!=null) {
        _name_1=_target.getName();
      }
      final String targetName = _name_1;
      Label _label = null;
      if (((AccessPrecedenceSpec)object)!=null) {
        _label=((AccessPrecedenceSpec)object).getLabel();
      }
      String _name_2 = null;
      if (_label!=null) {
        _name_2=_label.getName();
      }
      final String labelName = _name_2;
      AccessPrecedenceType _orderType = null;
      if (((AccessPrecedenceSpec)object)!=null) {
        _orderType=((AccessPrecedenceSpec)object).getOrderType();
      }
      final AccessPrecedenceType accessType = _orderType;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(originName);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = originName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(targetName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<runnable>";
      } else {
        _xifexpression_1 = targetName;
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(labelName);
      if (_isNullOrEmpty_2) {
        _xifexpression_2 = "<label>";
      } else {
        _xifexpression_2 = labelName;
      }
      final String s3 = _xifexpression_2;
      String _xifexpression_3 = null;
      if ((Objects.equal(accessType, null) || Objects.equal(accessType, AccessPrecedenceType._UNDEFINED_))) {
        _xifexpression_3 = "<access>";
      } else {
        _xifexpression_3 = accessType.getLiteral();
      }
      final String s4 = _xifexpression_3;
      return (((((((("Spec: " + s1) + " --> ") + s2) + " (") + s3) + " : ") + s4) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getAccessPrecedenceSpecItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(AccessPrecedenceSpec.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ACCESS_PRECEDENCE_SPEC__ORDER_TYPE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ACCESS_PRECEDENCE_SPEC__ORIGIN)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ACCESS_PRECEDENCE_SPEC__TARGET)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ACCESS_PRECEDENCE_SPEC__LABEL)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * OrderPrecedenceSpecItemProvider
   */
  public static String getOrderPrecedenceSpecItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof OrderPrecedenceSpec)) {
      org.eclipse.app4mc.amalthea.model.Runnable _origin = null;
      if (((OrderPrecedenceSpec)object)!=null) {
        _origin=((OrderPrecedenceSpec)object).getOrigin();
      }
      String _name = null;
      if (_origin!=null) {
        _name=_origin.getName();
      }
      final String originName = _name;
      org.eclipse.app4mc.amalthea.model.Runnable _target = null;
      if (((OrderPrecedenceSpec)object)!=null) {
        _target=((OrderPrecedenceSpec)object).getTarget();
      }
      String _name_1 = null;
      if (_target!=null) {
        _name_1=_target.getName();
      }
      final String targetName = _name_1;
      OrderType _orderType = null;
      if (((OrderPrecedenceSpec)object)!=null) {
        _orderType=((OrderPrecedenceSpec)object).getOrderType();
      }
      final OrderType order = _orderType;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(originName);
      if (_isNullOrEmpty) {
        _xifexpression = "<Runnable>";
      } else {
        _xifexpression = originName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(targetName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<Runnable>";
      } else {
        _xifexpression_1 = targetName;
      }
      final String s2 = _xifexpression_1;
      String _xifexpression_2 = null;
      if ((Objects.equal(order, null) || Objects.equal(order, OrderType._UNDEFINED_))) {
        _xifexpression_2 = "<order>";
      } else {
        _xifexpression_2 = order.getLiteral();
      }
      final String s3 = _xifexpression_2;
      return (((((("Spec: " + s1) + " --> ") + s2) + " (") + s3) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getOrderPrecedenceSpecItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(OrderPrecedenceSpec.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ORDER_PRECEDENCE_SPEC__ORDER_TYPE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ORDER_PRECEDENCE_SPEC__ORIGIN)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ORDER_PRECEDENCE_SPEC__TARGET)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * AsynchronousServerCallItemProvider
   */
  public static String getAsynchronousServerCallItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof AsynchronousServerCall)) {
      org.eclipse.app4mc.amalthea.model.Runnable _serverRunnable = null;
      if (((AsynchronousServerCall)object)!=null) {
        _serverRunnable=((AsynchronousServerCall)object).getServerRunnable();
      }
      String _name = null;
      if (_serverRunnable!=null) {
        _name=_serverRunnable.getName();
      }
      final String serverRun = _name;
      org.eclipse.app4mc.amalthea.model.Runnable _resultRunnable = null;
      if (((AsynchronousServerCall)object)!=null) {
        _resultRunnable=((AsynchronousServerCall)object).getResultRunnable();
      }
      String _name_1 = null;
      if (_resultRunnable!=null) {
        _name_1=_resultRunnable.getName();
      }
      final String resultRun = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(serverRun);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = serverRun;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(resultRun);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<runnable>";
      } else {
        _xifexpression_1 = resultRun;
      }
      final String s2 = _xifexpression_1;
      return (((("call server: " + s1) + " (async - result: ") + s2) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getAsynchronousServerCallItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(AsynchronousServerCall.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.ASYNCHRONOUS_SERVER_CALL__SERVER_RUNNABLE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.ASYNCHRONOUS_SERVER_CALL__RESULT_RUNNABLE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * SynchronousServerCallItemProvider
   */
  public static String getSynchronousServerCallItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SynchronousServerCall)) {
      org.eclipse.app4mc.amalthea.model.Runnable _serverRunnable = null;
      if (((SynchronousServerCall)object)!=null) {
        _serverRunnable=((SynchronousServerCall)object).getServerRunnable();
      }
      String _name = null;
      if (_serverRunnable!=null) {
        _name=_serverRunnable.getName();
      }
      final String serverRun = _name;
      WaitingBehaviour _waitingBehaviour = null;
      if (((SynchronousServerCall)object)!=null) {
        _waitingBehaviour=((SynchronousServerCall)object).getWaitingBehaviour();
      }
      final WaitingBehaviour waiting = _waitingBehaviour;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(serverRun);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = serverRun;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      if ((Objects.equal(waiting, null) || Objects.equal(waiting, WaitingBehaviour._UNDEFINED_))) {
        _xifexpression_1 = "undefined";
      } else {
        _xifexpression_1 = waiting.getLiteral();
      }
      final String s2 = _xifexpression_1;
      return (((("call server: " + s1) + " (sync - ") + s2) + " waiting)");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSynchronousServerCallItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SynchronousServerCall.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SYNCHRONOUS_SERVER_CALL__SERVER_RUNNABLE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.SYNCHRONOUS_SERVER_CALL__WAITING_BEHAVIOUR)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ChainedProcessPrototypeItemProvider
   */
  public static String getChainedProcessPrototypeItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ChainedProcessPrototype)) {
      ProcessPrototype _prototype = null;
      if (((ChainedProcessPrototype)object)!=null) {
        _prototype=((ChainedProcessPrototype)object).getPrototype();
      }
      String _name = null;
      if (_prototype!=null) {
        _name=_prototype.getName();
      }
      final String proto = _name;
      int _xifexpression = (int) 0;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = ((ChainedProcessPrototype)object).getApply();
      }
      final int apply = _xifexpression;
      int _xifexpression_1 = (int) 0;
      boolean _equals_1 = Objects.equal(object, null);
      if (_equals_1) {
        _xifexpression_1 = 0;
      } else {
        _xifexpression_1 = ((ChainedProcessPrototype)object).getOffset();
      }
      final int offset = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(proto);
      if (_isNullOrEmpty) {
        _xifexpression_2 = "<process prototype>";
      } else {
        _xifexpression_2 = proto;
      }
      final String s1 = _xifexpression_2;
      return (((((("Chained Prototype " + s1) + "(apply: ") + Integer.valueOf(apply)) + " offset: ") + Integer.valueOf(offset)) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getChainedProcessPrototypeItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ChainedProcessPrototype.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.CHAINED_PROCESS_PROTOTYPE__PROTOTYPE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CHAINED_PROCESS_PROTOTYPE__APPLY)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CHAINED_PROCESS_PROTOTYPE__OFFSET)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * GroupItemProvider
   */
  public static String getGroupItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof Group)) {
      String _xifexpression = null;
      String _name = ((Group)object).getName();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = null;
      } else {
        _xifexpression = ((Group)object).getName();
      }
      final String name = _xifexpression;
      boolean _xifexpression_1 = false;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression_1 = false;
      } else {
        _xifexpression_1 = ((Group)object).isOrdered();
      }
      final boolean ordered = _xifexpression_1;
      String _xifexpression_2 = null;
      if (ordered) {
        _xifexpression_2 = "(Sequence)";
      } else {
        _xifexpression_2 = "(Set)";
      }
      final String result = _xifexpression_2;
      String _xifexpression_3 = null;
      boolean _equals_1 = Objects.equal(name, null);
      if (_equals_1) {
        _xifexpression_3 = result;
      } else {
        _xifexpression_3 = ((result + " ") + name);
      }
      return _xifexpression_3;
    }
    return null;
  }
  
  public static String getGroupItemProviderImageName(final Object object) {
    if ((object instanceof Group)) {
      boolean _xifexpression = false;
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        _xifexpression = false;
      } else {
        _xifexpression = ((Group)object).isOrdered();
      }
      final boolean ordered = _xifexpression;
      String _xifexpression_1 = null;
      if (ordered) {
        _xifexpression_1 = "ordered";
      } else {
        _xifexpression_1 = "unordered";
      }
      return ("Group_" + _xifexpression_1);
    }
    return null;
  }
  
  /**
   * InterProcessActivationItemProvider
   */
  public static String getInterProcessActivationItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof InterProcessActivation)) {
      Stimulus _stimulus = null;
      if (((InterProcessActivation)object)!=null) {
        _stimulus=((InterProcessActivation)object).getStimulus();
      }
      String _name = null;
      if (_stimulus!=null) {
        _name=_stimulus.getName();
      }
      final String sitmulusName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(sitmulusName);
      if (_isNullOrEmpty) {
        _xifexpression = "<stimulus>";
      } else {
        _xifexpression = sitmulusName;
      }
      final String s1 = _xifexpression;
      return ("activate " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getInterProcessActivationItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(InterProcessActivation.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.INTER_PROCESS_ACTIVATION__STIMULUS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ModeLiteralItemProvider
   */
  public static String getModeLiteralItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeLiteral)) {
      return ((ModeLiteral)object).toString();
    } else {
      return defaultText;
    }
  }
  
  /**
   * ModeLabelItemProvider
   */
  public static String getModeLabelItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeLabel)) {
      final String name = ((ModeLabel)object).getName();
      Mode _mode = ((ModeLabel)object).getMode();
      String _name = null;
      if (_mode!=null) {
        _name=_mode.getName();
      }
      final String modeName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<mode label>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(modeName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<mode>";
      } else {
        _xifexpression_1 = modeName;
      }
      final String s2 = _xifexpression_1;
      return (((s1 + " (") + s2) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getModeLabelItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ModeLabel.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.MODE_LABEL__NAME)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.MODE_LABEL__MODE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ModeSwitchItemProvider
   */
  public static String getModeSwitchItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeSwitch)) {
      ModeValueProvider _valueProvider = ((ModeSwitch)object).getValueProvider();
      String _name = null;
      if (_valueProvider!=null) {
        _name=_valueProvider.getName();
      }
      final String valueName = _name;
      ModeValueProvider _valueProvider_1 = ((ModeSwitch)object).getValueProvider();
      Mode _mode = null;
      if (_valueProvider_1!=null) {
        _mode=_valueProvider_1.getMode();
      }
      String _name_1 = null;
      if (_mode!=null) {
        _name_1=_mode.getName();
      }
      final String modeName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(valueName);
      if (_isNullOrEmpty) {
        _xifexpression = "<mode label>";
      } else {
        _xifexpression = valueName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(modeName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<mode>";
      } else {
        _xifexpression_1 = modeName;
      }
      final String s2 = _xifexpression_1;
      return (((("Switch " + s1) + " (") + s2) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getModeSwitchItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ModeSwitch.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.MODE_SWITCH__VALUE_PROVIDER)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.MODE_SWITCH__ENTRIES)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(_featureID, AmaltheaPackage.MODE_SWITCH__DEFAULT_ENTRY)) {
          _matched=true;
        }
      }
      if (_matched) {
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * RunnableModeSwitchItemProvider
   */
  public static String getRunnableModeSwitchItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableModeSwitch)) {
      ModeValueProvider _valueProvider = ((RunnableModeSwitch)object).getValueProvider();
      String _name = null;
      if (_valueProvider!=null) {
        _name=_valueProvider.getName();
      }
      final String valueName = _name;
      ModeValueProvider _valueProvider_1 = ((RunnableModeSwitch)object).getValueProvider();
      Mode _mode = null;
      if (_valueProvider_1!=null) {
        _mode=_valueProvider_1.getMode();
      }
      String _name_1 = null;
      if (_mode!=null) {
        _name_1=_mode.getName();
      }
      final String modeName = _name_1;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(valueName);
      if (_isNullOrEmpty) {
        _xifexpression = "<mode label>";
      } else {
        _xifexpression = valueName;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(modeName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<mode>";
      } else {
        _xifexpression_1 = modeName;
      }
      final String s2 = _xifexpression_1;
      return (((("Switch " + s1) + " (") + s2) + ")");
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableModeSwitchItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableModeSwitch.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_MODE_SWITCH__VALUE_PROVIDER)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_MODE_SWITCH__ENTRIES)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_MODE_SWITCH__DEFAULT_ENTRY)) {
          _matched=true;
        }
      }
      if (_matched) {
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ModeSwitchEntryItemProvider
   */
  public static String getModeSwitchEntryItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeSwitchEntry<?>)) {
      EList<ModeLiteral> _values = null;
      if (((ModeSwitchEntry<?>)object)!=null) {
        _values=((ModeSwitchEntry<?>)object).getValues();
      }
      String _join = null;
      if (_values!=null) {
        final Function1<ModeLiteral, CharSequence> _function = (ModeLiteral it) -> {
          return it.getName();
        };
        _join=IterableExtensions.<ModeLiteral>join(_values, "", ", ", "", _function);
      }
      final String valueName = _join;
      final String s1 = "case: ";
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(valueName);
      if (_isNullOrEmpty) {
        _xifexpression = "<mode literals>";
      } else {
        _xifexpression = valueName;
      }
      final String s2 = _xifexpression;
      return (s1 + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getModeSwitchEntryItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ModeSwitchEntry.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.MODE_SWITCH_ENTRY__ITEMS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, true, false);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.MODE_SWITCH_ENTRY__VALUES)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, false, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ModeSwitchDefaultItemProvider
   */
  public static String getModeSwitchDefaultItemProviderText(final Object object, final String defaultText) {
    return "default";
  }
  
  /**
   * TaskRunnableCallItemProvider
   */
  public static String getTaskRunnableCallItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TaskRunnableCall)) {
      org.eclipse.app4mc.amalthea.model.Runnable _runnable = null;
      if (((TaskRunnableCall)object)!=null) {
        _runnable=((TaskRunnableCall)object).getRunnable();
      }
      String _name = null;
      if (_runnable!=null) {
        _name=_runnable.getName();
      }
      final String runName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(runName);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = runName;
      }
      final String s1 = _xifexpression;
      return ("call " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTaskRunnableCallItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TaskRunnableCall.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TASK_RUNNABLE_CALL__RUNNABLE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.TASK_RUNNABLE_CALL__STATISTIC)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * LabelAccessItemProvider
   */
  public static String getLabelAccessItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof LabelAccess)) {
      LabelAccessEnum _access = null;
      if (((LabelAccess)object)!=null) {
        _access=((LabelAccess)object).getAccess();
      }
      final LabelAccessEnum access = _access;
      Label _data = null;
      if (((LabelAccess)object)!=null) {
        _data=((LabelAccess)object).getData();
      }
      String _name = null;
      if (_data!=null) {
        _name=_data.getName();
      }
      final String labelName = _name;
      String _xifexpression = null;
      if ((Objects.equal(access, null) || Objects.equal(access, LabelAccessEnum._UNDEFINED_))) {
        _xifexpression = "<access>";
      } else {
        _xifexpression = access.getLiteral();
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(labelName);
      if (_isNullOrEmpty) {
        _xifexpression_1 = "<label>";
      } else {
        _xifexpression_1 = labelName;
      }
      final String s2 = _xifexpression_1;
      return ((s1 + " ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getLabelAccessItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(LabelAccess.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.LABEL_ACCESS__ACCESS)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LABEL_ACCESS__DATA)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.LABEL_ACCESS__STATISTIC)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ChannelAccessItemProvider
   */
  public static List<ViewerNotification> getChannelAccessItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ChannelAccess.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.CHANNEL_ACCESS__DATA)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.CHANNEL_ACCESS__TRANSMISSION_POLICY)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * ChannelReceiveItemProvider
   */
  public static String getChannelReceiveItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ChannelReceive)) {
      Channel _data = null;
      if (((ChannelReceive)object)!=null) {
        _data=((ChannelReceive)object).getData();
      }
      String _name = null;
      if (_data!=null) {
        _name=_data.getName();
      }
      final String data = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(data);
      if (_isNullOrEmpty) {
        _xifexpression = "<channel>";
      } else {
        _xifexpression = data;
      }
      final String s1 = _xifexpression;
      return ("receive from " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * ChannelSendItemProvider
   */
  public static String getChannelSendItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ChannelSend)) {
      Channel _data = null;
      if (((ChannelSend)object)!=null) {
        _data=((ChannelSend)object).getData();
      }
      String _name = null;
      if (_data!=null) {
        _name=_data.getName();
      }
      final String data = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(data);
      if (_isNullOrEmpty) {
        _xifexpression = "<channel>";
      } else {
        _xifexpression = data;
      }
      final String s1 = _xifexpression;
      return ("send to " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * SemaphoreAccessItemProvider
   */
  public static String getSemaphoreAccessItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SemaphoreAccess)) {
      SemaphoreAccessEnum _access = null;
      if (((SemaphoreAccess)object)!=null) {
        _access=((SemaphoreAccess)object).getAccess();
      }
      final SemaphoreAccessEnum access = _access;
      Semaphore _semaphore = null;
      if (((SemaphoreAccess)object)!=null) {
        _semaphore=((SemaphoreAccess)object).getSemaphore();
      }
      String _name = null;
      if (_semaphore!=null) {
        _name=_semaphore.getName();
      }
      final String semName = _name;
      String _xifexpression = null;
      if ((Objects.equal(access, null) || Objects.equal(access, SemaphoreAccessEnum._UNDEFINED_))) {
        _xifexpression = "<access>";
      } else {
        _xifexpression = access.getLiteral();
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(semName);
      if (_isNullOrEmpty) {
        _xifexpression_1 = "<semaphore>";
      } else {
        _xifexpression_1 = semName;
      }
      final String s2 = _xifexpression_1;
      return ((s1 + " ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSemaphoreAccessItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SemaphoreAccess.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SEMAPHORE_ACCESS__ACCESS)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.SEMAPHORE_ACCESS__SEMAPHORE)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * ModeLabelAccessItemProvider
   */
  public static String getModeLabelAccessItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ModeLabelAccess)) {
      LabelAccessEnum _access = null;
      if (((ModeLabelAccess)object)!=null) {
        _access=((ModeLabelAccess)object).getAccess();
      }
      final LabelAccessEnum access = _access;
      ModeLabel _data = null;
      if (((ModeLabelAccess)object)!=null) {
        _data=((ModeLabelAccess)object).getData();
      }
      String _name = null;
      if (_data!=null) {
        _name=_data.getName();
      }
      final String label = _name;
      String _xifexpression = null;
      if ((Objects.equal(access, null) || Objects.equal(access, LabelAccessEnum._UNDEFINED_))) {
        _xifexpression = "<access>";
      } else {
        _xifexpression = access.getLiteral();
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(label);
      if (_isNullOrEmpty) {
        _xifexpression_1 = "<mode label>";
      } else {
        _xifexpression_1 = label;
      }
      final String s2 = _xifexpression_1;
      return ((s1 + " ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getModeLabelAccessItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(ModeLabelAccess.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.MODE_LABEL_ACCESS__ACCESS)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.MODE_LABEL_ACCESS__DATA)) {
        _matched=true;
      }
    }
    if (_matched) {
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * RunnableInstructionsEntryItemProvider
   */
  public static String getRunnableInstructionsEntryItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableInstructionsEntryImpl)) {
      CoreType _key = null;
      if (((RunnableInstructionsEntryImpl)object)!=null) {
        _key=((RunnableInstructionsEntryImpl)object).getKey();
      }
      String _name = null;
      if (_key!=null) {
        _name=_key.getName();
      }
      final String typeName = _name;
      Instructions _value = null;
      if (((RunnableInstructionsEntryImpl)object)!=null) {
        _value=((RunnableInstructionsEntryImpl)object).getValue();
      }
      final Instructions instr = _value;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeName);
      if (_isNullOrEmpty) {
        _xifexpression = "<core type>";
      } else {
        _xifexpression = ("Core Type " + typeName);
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _equals = Objects.equal(instr, null);
      if (_equals) {
        _xifexpression_1 = "<instructions>";
      } else {
        _xifexpression_1 = CustomItemProviderService.getInstructionsText(instr);
      }
      final String s2 = _xifexpression_1;
      return ((s1 + " -- ") + s2);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableInstructionsEntryItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(Map.Entry.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_INSTRUCTIONS_ENTRY__KEY)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_INSTRUCTIONS_ENTRY__VALUE)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, true);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * RunnableCallItemProvider
   */
  public static String getRunnableCallItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof RunnableCall)) {
      org.eclipse.app4mc.amalthea.model.Runnable _runnable = null;
      if (((RunnableCall)object)!=null) {
        _runnable=((RunnableCall)object).getRunnable();
      }
      String _name = null;
      if (_runnable!=null) {
        _name=_runnable.getName();
      }
      final String runName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(runName);
      if (_isNullOrEmpty) {
        _xifexpression = "<runnable>";
      } else {
        _xifexpression = runName;
      }
      final String s1 = _xifexpression;
      return ("call " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getRunnableCallItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(RunnableCall.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_CALL__RUNNABLE)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    if (!_matched) {
      if (Objects.equal(_featureID, AmaltheaPackage.RUNNABLE_CALL__STATISTIC)) {
        _matched=true;
        Object _notifier_1 = notification.getNotifier();
        ViewerNotification _viewerNotification_1 = new ViewerNotification(notification, _notifier_1, true, false);
        list.add(_viewerNotification_1);
      }
    }
    return list;
  }
  
  /**
   * SenderReceiverReadItemProvider
   */
  public static String getSenderReceiverReadItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SenderReceiverRead)) {
      Label _label = null;
      if (((SenderReceiverRead)object)!=null) {
        _label=((SenderReceiverRead)object).getLabel();
      }
      String _name = null;
      if (_label!=null) {
        _name=_label.getName();
      }
      final String labelName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(labelName);
      if (_isNullOrEmpty) {
        _xifexpression = "<label>";
      } else {
        _xifexpression = ("Label " + labelName);
      }
      final String s1 = _xifexpression;
      return ("Sender Receiver - Read " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSenderReceiverReadItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SenderReceiverRead.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SENDER_RECEIVER_READ__LABEL)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * SenderReceiverWriteItemProvider
   */
  public static String getSenderReceiverWriteItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SenderReceiverWrite)) {
      Label _label = null;
      if (((SenderReceiverWrite)object)!=null) {
        _label=((SenderReceiverWrite)object).getLabel();
      }
      String _name = null;
      if (_label!=null) {
        _name=_label.getName();
      }
      final String labelName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(labelName);
      if (_isNullOrEmpty) {
        _xifexpression = "<label>";
      } else {
        _xifexpression = ("Label " + labelName);
      }
      final String s1 = _xifexpression;
      return ("Sender Receiver - Write " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSenderReceiverWriteItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SenderReceiverWrite.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SENDER_RECEIVER_WRITE__LABEL)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * SetEventItemProvider
   */
  public static String getSetEventItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof SetEvent)) {
      org.eclipse.app4mc.amalthea.model.Process _process = null;
      if (((SetEvent)object)!=null) {
        _process=((SetEvent)object).getProcess();
      }
      final org.eclipse.app4mc.amalthea.model.Process proc = _process;
      String _xifexpression = null;
      String _name = null;
      if (proc!=null) {
        _name=proc.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        _xifexpression = "<process>";
      } else {
        EClass _eClass = proc.eClass();
        String _name_1 = _eClass.getName();
        String _plus = (_name_1 + " ");
        String _name_2 = proc.getName();
        _xifexpression = (_plus + _name_2);
      }
      final String s1 = _xifexpression;
      return ("SetEvent " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getSetEventItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(SetEvent.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.SET_EVENT__PROCESS)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * WaitEventItemProvider
   */
  public static String getWaitEventItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof WaitEvent)) {
      WaitingBehaviour _waitingBehaviour = null;
      if (((WaitEvent)object)!=null) {
        _waitingBehaviour=((WaitEvent)object).getWaitingBehaviour();
      }
      final WaitingBehaviour waiting = _waitingBehaviour;
      String _xifexpression = null;
      if ((Objects.equal(waiting, null) || Objects.equal(waiting, WaitingBehaviour._UNDEFINED_))) {
        _xifexpression = "<waiting>";
      } else {
        _xifexpression = waiting.getLiteral();
      }
      final String s1 = _xifexpression;
      return ("WaitEvent " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * ClearEventItemProvider
   */
  public static String getClearEventItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof ClearEvent)) {
      return "ClearEvent";
    } else {
      return defaultText;
    }
  }
  
  /**
   * BaseTypeDefinitionItemProvider
   */
  public static String getBaseTypeDefinitionItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof BaseTypeDefinition)) {
      String _name = null;
      if (((BaseTypeDefinition)object)!=null) {
        _name=((BaseTypeDefinition)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<type definition>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return ("BaseType " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * TypeDefinitionItemProvider
   */
  public static String getTypeDefinitionItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TypeDefinition)) {
      String _name = null;
      if (((TypeDefinition)object)!=null) {
        _name=((TypeDefinition)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<type definition>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return ("Type " + s1);
    } else {
      return defaultText;
    }
  }
  
  /**
   * TypeRefItemProvider
   */
  public static String getTypeRefItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof TypeRef)) {
      TypeDefinition _typeDef = null;
      if (((TypeRef)object)!=null) {
        _typeDef=((TypeRef)object).getTypeDef();
      }
      String _name = null;
      if (_typeDef!=null) {
        _name=_typeDef.getName();
      }
      final String typeName = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeName);
      if (_isNullOrEmpty) {
        _xifexpression = "<type definition>";
      } else {
        _xifexpression = typeName;
      }
      final String s1 = _xifexpression;
      return ("TypeRef " + s1);
    } else {
      return defaultText;
    }
  }
  
  public static List<ViewerNotification> getTypeRefItemProviderNotifications(final Notification notification) {
    final ArrayList<ViewerNotification> list = CollectionLiterals.<ViewerNotification>newArrayList();
    int _featureID = notification.getFeatureID(TypeRef.class);
    boolean _matched = false;
    if (Objects.equal(_featureID, AmaltheaPackage.TYPE_REF__TYPE_DEF)) {
      _matched=true;
      Object _notifier = notification.getNotifier();
      ViewerNotification _viewerNotification = new ViewerNotification(notification, _notifier, false, true);
      list.add(_viewerNotification);
    }
    return list;
  }
  
  /**
   * DataPlatformMappingItemProvider
   */
  public static String getDataPlatformMappingItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataPlatformMapping)) {
      String _platformName = null;
      if (((DataPlatformMapping)object)!=null) {
        _platformName=((DataPlatformMapping)object).getPlatformName();
      }
      final String name = _platformName;
      String _platformType = null;
      if (((DataPlatformMapping)object)!=null) {
        _platformType=((DataPlatformMapping)object).getPlatformType();
      }
      final String typeName = _platformType;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "<platform>";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(typeName);
      if (_isNullOrEmpty_1) {
        _xifexpression_1 = "<type>";
      } else {
        _xifexpression_1 = typeName;
      }
      final String s2 = _xifexpression_1;
      return ((("Platform Mapping: " + s1) + " --> ") + s2);
    } else {
      return defaultText;
    }
  }
  
  /**
   * DataTypeDefinitionItemProvider
   */
  public static String getDataTypeDefinitionItemProviderText(final Object object, final String defaultText) {
    if ((object instanceof DataTypeDefinition)) {
      String _name = null;
      if (((DataTypeDefinition)object)!=null) {
        _name=((DataTypeDefinition)object).getName();
      }
      final String name = _name;
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "???";
      } else {
        _xifexpression = name;
      }
      final String s1 = _xifexpression;
      return ("DataType " + s1);
    } else {
      return defaultText;
    }
  }
}
