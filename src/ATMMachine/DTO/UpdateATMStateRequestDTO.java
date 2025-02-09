package ATMMachine.DTO;

import ATMMachine.enums.ATMState;

public class UpdateATMStateRequestDTO {

        private final String atmID;
        private final ATMState state;

        public UpdateATMStateRequestDTO(String atmID, ATMState state) {
            this.atmID = atmID;
            this.state = state;
        }

        public String getAtmID() {
            return atmID;
        }

        public ATMState getState() {
            return state;
        }
}
