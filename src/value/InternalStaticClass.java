package value;

/**
 * Created by AlanJager on 2017/4/19.
 */
public class InternalStaticClass {
    public static void main(String[] args) {
        AgentResponse agentResponse = new AgentResponse();
        agentResponse.setAvailableCapacity(10000);
        agentResponse.setTotalCapacity(10000);

        AgentResponse temp = new AgentResponse();
        System.out.println(temp.getAvailableCapacity());
        System.out.println(temp.getTotalCapacity());
    }

    public static class AgentResponse {
        public long getTotalCapacity() {
            return totalCapacity;
        }

        public void setTotalCapacity(long totalCapacity) {
            this.totalCapacity = totalCapacity;
        }

        public long getAvailableCapacity() {
            return availableCapacity;
        }

        public void setAvailableCapacity(long availableCapacity) {
            this.availableCapacity = availableCapacity;
        }

        private long totalCapacity;
        private long availableCapacity;
    }

    public static class AgentCmd {

    }
}
