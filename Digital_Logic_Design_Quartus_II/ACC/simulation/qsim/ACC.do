onerror {quit -f}
vlib work
vlog -work work ACC.vo
vlog -work work ACC.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.ACC_vlg_vec_tst
vcd file -direction ACC.msim.vcd
vcd add -internal ACC_vlg_vec_tst/*
vcd add -internal ACC_vlg_vec_tst/i1/*
add wave /*
run -all
