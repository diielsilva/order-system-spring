package com.olix.order_system.common.mapper;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.olix.order_system.api.representation.input.SaveEntry;
import com.olix.order_system.api.representation.input.SaveEntryItem;
import com.olix.order_system.api.representation.input.SaveExit;
import com.olix.order_system.api.representation.input.SaveExitItem;
import com.olix.order_system.api.representation.input.SaveProduct;
import com.olix.order_system.api.representation.input.UpdateProduct;
import com.olix.order_system.api.representation.output.ShowEntry;
import com.olix.order_system.api.representation.output.ShowEntryItem;
import com.olix.order_system.api.representation.output.ShowExit;
import com.olix.order_system.api.representation.output.ShowExitItem;
import com.olix.order_system.api.representation.output.ShowProduct;
import com.olix.order_system.domain.model.Entry;
import com.olix.order_system.domain.model.EntryItem;
import com.olix.order_system.domain.model.Exit;
import com.olix.order_system.domain.model.ExitItem;
import com.olix.order_system.domain.model.Product;

@Component
public class ModelMapper {

	public Product fromSaveProductToProductModel(SaveProduct saveProduct) {
		Product productToSave = new Product(null, saveProduct.getName(), 0L);
		return productToSave;
	}

	public Product fromUpdateProductToProductModel(UpdateProduct updateProduct) {
		Product productToUpdate = new Product(null, updateProduct.getName(), null);
		return productToUpdate;
	}

	public ShowProduct fromProductModelToShowProduct(Product product) {
		ShowProduct productToShow = new ShowProduct(product.getId(), product.getName(), product.getAmount());
		return productToShow;
	}

	public Page<ShowProduct> fromProductModelPageToShowProductPage(Page<Product> productModelPage) {
		Page<ShowProduct> showProductPage = productModelPage.map(new Function<Product, ShowProduct>() {
			@Override
			public ShowProduct apply(Product product) {
				return fromProductModelToShowProduct(product);
			}
		});
		return showProductPage;
	}

	public Entry fromSaveEntryToEntryModel(SaveEntry saveEntry) {
		Entry entry = new Entry();
		for (SaveEntryItem saveEntryItem : saveEntry.getEntryItems()) {
			Product product = new Product(saveEntryItem.getProductId(), null, null);
			EntryItem entryItem = new EntryItem(null, saveEntryItem.getAmount(), null, product);
			entry.getEntryItems().add(entryItem);
		}
		return entry;
	}

	public ShowEntry fromEntryModelToShowEntry(Entry entry) {
		ShowEntry showEntry = new ShowEntry();
		showEntry.setId(entry.getId());
		showEntry.setEntryDateTime(entry.getEntryDateTime());
		for (EntryItem entryItem : entry.getEntryItems()) {
			ShowProduct showProduct = new ShowProduct(entryItem.getProduct().getId(), entryItem.getProduct().getName(),
					entryItem.getProduct().getAmount());
			ShowEntryItem showEntryItem = new ShowEntryItem(entryItem.getId(), entryItem.getAmount(), showProduct);
			showEntry.getEntryItems().add(showEntryItem);
		}
		return showEntry;
	}

	public Page<ShowEntry> fromEntryModelPageToShowEntryPage(Page<Entry> entryModelPage) {
		Page<ShowEntry> showEntryPage = entryModelPage.map(new Function<Entry, ShowEntry>() {
			@Override
			public ShowEntry apply(Entry entry) {
				return fromEntryModelToShowEntry(entry);
			}
		});
		return showEntryPage;
	}

	public Exit fromSaveExitToExitModel(SaveExit saveExit) {
		Exit exit = new Exit();
		for (SaveExitItem saveExitItem : saveExit.getExitItems()) {
			Product product = new Product(saveExitItem.getProductId(), null, null);
			ExitItem exitItem = new ExitItem(null, saveExitItem.getAmount(), null, product);
			exit.getExitItems().add(exitItem);
		}
		return exit;
	}

	public ShowExit fromExitModelToShowExit(Exit exit) {
		ShowExit showExit = new ShowExit();
		showExit.setId(exit.getId());
		showExit.setExitDateTime(exit.getExitDateTime());
		for (ExitItem exitItem : exit.getExitItems()) {
			ShowProduct showProduct = new ShowProduct(exitItem.getProduct().getId(), exitItem.getProduct().getName(),
					exitItem.getProduct().getAmount());
			ShowExitItem showExitItem = new ShowExitItem(exitItem.getId(), exitItem.getAmount(), showProduct);
			showExit.getExitItems().add(showExitItem);
		}
		return showExit;
	}

	public Page<ShowExit> fromExitModelPageToShowExitPage(Page<Exit> exitModelPage) {
		Page<ShowExit> showExitPage = exitModelPage.map(new Function<Exit, ShowExit>() {
			@Override
			public ShowExit apply(Exit exit) {
				return fromExitModelToShowExit(exit);
			}
		});
		return showExitPage;
	}
}