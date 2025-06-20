package data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultTemplatesNames {

    ESERVICES_AGENT_ACTIVITY("eServices Agent Activity"),
    AGENT_GROUP_STATUS("Agent Group Status"),
    AGENT_KPIS("Agent KPIs"),
    AGENT_LOGIN("Agent Login"),
    CALLBACK_ACTIVITY("Callback Activity"),
    CAMPAIGN_ACTIVITY("Campaign Activity"),
    CAMPAIGN_CALLBACK_STATUS("Campaign Callback Status"),
    CAMPAIGN_GROUP_ACTIVITY("Campaign Group Activity"),
    CAMPAIGN_GROUP_STATUS("Campaign Group Status"),
    CHAT_AGENT_ACTIVITY("Chat Agent Activity"),
    CHAT_QUEUE_ACTIVITY("Chat Queue Activity"),
    CHAT_SERVICE_LEVEL_PERFORMANCE("Chat Service Level Performance"),
    CHAT_WAITING_STATISTICS("Chat Waiting Statistics (IxnQ, GroupBy)"),
    EMAIL_AGENT_ACTIVITY("Email Agent Activity"),
    EMAIL_QUEUE_ACTIVITY("Email Queue Activity"),
    ESERVICES_QUEUE_KPIS("eServices Queue KPIs"),
    FACEBOOK_MEDIA_ACTIVITY("Facebook Media Activity"),
    IWD_AGENT_ACTIVITY("IWD Agent Activity"),
    IWD_QUEUE_ACTIVITY("IWD Queue Activity"),
    QUEUE_KPIS("Queue KPIs"),
    QUEUE_OVERFLOW_REASON("Queue Overflow Reason"),
    TWITTER_MEDIA_ACTIVITY("Twitter Media Activity");

    private final String type;

}