.global getName 
.global getZip

.text

// char* getName(const BUSINESS business[], uint32_t index)
// address of business[0].taxId in R0, index in R1 -? return char* in 
getName:
    ADD R0, R0, #4 // R0 = &business[0].name[0]
    MOV R2, #120   // R2 = sizeof(BUSINESS)
    MUL R3, R2, R1 // R3 = index * sizeof(BUSINESS)
    ADD R0, R0, R3 // R0 = &business[index].name[0]
    BX LR

// uint32_t getZip(const BUSINESS business[], uint32_t index)
// address of business[0].taxId in R0, index in R1 -? return zip code in R0
getZip:
    ADD R0, R0, #116 // R0 = &business[0].zip
    MOV R2, #120     // R2 = sizeof(BUSINESS)
    MUL R3, R2, R1   // R3 = index * sizeof(BUSINESS)
    ADD R0, R0, R3   // R0 = &business[index].zip
    LDR R0, [R0]     // R0 = *R0 = business[index].zip
    BX LR
