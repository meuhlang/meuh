package cmd

import (
	"fmt"

	"github.com/spf13/cobra"
)

var lexerCmd = &cobra.Command{
	Use:   "lexer",
	Short: "Run the lexer on the given files",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Println("lexer called")
	},
}

func init() {
	rootCmd.AddCommand(lexerCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// pouetCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// pouetCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}
