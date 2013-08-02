package factory;

import bean.ConwayRule;
import bean.Rule;
import bean.RuleType;

public class RuleFactory {
  public static Rule createRule(RuleType type) {
    if (RuleType.CONWAY == type) {
      return new ConwayRule();
    }

    return null;
  }
}
