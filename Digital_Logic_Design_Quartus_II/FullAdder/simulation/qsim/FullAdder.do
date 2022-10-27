onerror {quit -f}
vlib work
vlog -work work FullAdder.vo
vlog -work work FullAdder.vt
vsim -novopt -c -t 1ps -L cycloneiv_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.FullAdder_vlg_vec_tst
vcd file -direction FullAdder.msim.vcd
vcd add -internal FullAdder_vlg_vec_tst/*
vcd add -internal FullAdder_vlg_vec_tst/i1/*
add wave /*
run -all
